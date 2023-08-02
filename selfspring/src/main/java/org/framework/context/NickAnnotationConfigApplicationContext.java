package org.framework.context;

import org.framework.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Nick
 * @Classname NickAnnotationConfigApplicationContext
 * @Date 2023/07/27 16:00
 * @Description TODO
 */
public class NickAnnotationConfigApplicationContext implements NickApplicationContext {
	private Logger logger = LoggerFactory.getLogger(NickAnnotationConfigApplicationContext.class);

	//存每个待托管的Bean定义信息
	// private Map<String, NickBeanDefinition> beanDefinitionMap = new HashMap<>();
	private Map<String, NickBeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();
	//存每个实例化后的bean
	private Map<String, Object> beanMap = new HashMap<>();
	//存系统属性,db.properties
	private Properties props = new Properties();

	public NickAnnotationConfigApplicationContext(Class... configClasses) {

		try {
			//读取系统属性
			props = System.getProperties();
			List<String> toScanPackagePath = new ArrayList<>();
			for (Class cls : configClasses) {
				if (!cls.isAnnotationPresent(NickConfiguration.class)) {
					continue;
				}
				String[] basePackages = null;
				//扫描配置类上的@NickComponentScan注解,读取要扫描的包
				if (cls.isAnnotationPresent(NickComponentScan.class)) {
					NickComponentScan annotation = (NickComponentScan) cls.getAnnotation(NickComponentScan.class);
					basePackages = annotation.basePackages();
					if (basePackages == null || basePackages.length <= 0) {
						basePackages = new String[1];
						basePackages[0] = cls.getPackage().getName();
					}
					logger.info(cls.getName() + " 类上有@NickComponentScan注解,他要扫描的路径: " + basePackages[0]);
				}
				// 开始扫描这些basePackages包下的bean,并加载包装成NickBeanDefinition对象,存到beanDefinitionMap中
				recursiveLoadBeanDefinition(basePackages);
			}
			//	循环beanDefinitionMap,创建bean(是否懒加载,单例),存到beanMap
			createBean();
			//	循环所有托管的beanMap中的bean,看属性上是否有@Autowired,@Resource,@Value...,考虑DI
			doDi();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		}
	}

	private void doDi() throws IllegalAccessException, InstantiationException, ClassNotFoundException {
		//	循环beanMap,这是托管bean
		for (Map.Entry<String, Object> entry : beanMap.entrySet()) {
			String beanId = entry.getKey();
			//业务类的bean
			Object beanObj = entry.getValue();
			System.out.println("beanObj = " + beanObj);
			System.out.println("beanObj.getClass() = " + beanObj.getClass());
			//	情况一: 属性上有@NickResource
			Field[] fields = beanObj.getClass().getDeclaredFields();
			for (Field field : fields) {
				if (field.isAnnotationPresent(NickResource.class)) {
					NickResource annotation = field.getAnnotation(NickResource.class);
					String toBeanId = annotation.name();
					//	从beanMap中找,是否singleton,是否lazy,要注入dao的bean
					Object obj = getToDiBean(toBeanId);
					System.out.println("obj = " + obj);
					//	注入
					field.setAccessible(true);
					//userBizImpl <- beanObj
					//userDao <- obj
					field.set(beanObj, obj);
				}
			}
			//	todo:情况二: 方法上有@NickResource
			//	todo:情况三: 构造方法上有@NickResource

		}
	}

	private Object getToDiBean(String toBeanId) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
		if (beanMap.containsKey(toBeanId)) {
			return beanMap.get(toBeanId);
		}
		//判断beanMap中没有此bean是因为lazy
		if (!beanDefinitionMap.containsKey(toBeanId)) {
			throw new RuntimeException("spring容器中没有加载此class: " + toBeanId);
		}
		NickBeanDefinition definition = beanDefinitionMap.get(toBeanId);
		if (definition.isLazy()) {
			//classInfo => com/nick/spring...
			String classInfo = definition.getClassInfo();
			Object beanObj = Class.forName(classInfo).newInstance();
			beanMap.put(toBeanId, beanObj);
			return beanObj;
		}
		//判断beanMap中没有此bean是因为prototype
		if (definition.getScope().equalsIgnoreCase("prototype")) {
			String classInfo = definition.getClassInfo();
			Object beanObj = Class.forName(classInfo).newInstance();
			return beanObj;
		}
		return null;
	}

	private void createBean() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
		for (Map.Entry<String, NickBeanDefinition> entry : beanDefinitionMap.entrySet()) {
			String beanId = entry.getKey();
			NickBeanDefinition definition = entry.getValue();
			if (!definition.isLazy() && !definition.getScope().equalsIgnoreCase("prototype")) {
				String classInfo = definition.getClassInfo();
				Object obj = Class.forName(classInfo).newInstance();
				beanMap.put(beanId, obj);
				logger.trace("spring容器托管了: " + beanId + " => " + classInfo);
			}
		}
	}

	private void recursiveLoadBeanDefinition(String[] basePackages) {
		for (String basePackage : basePackages) {
			// basePackage => com.nick.selfspring
			String packagePath = basePackage.replaceAll("\\.", "/");
			Enumeration<URL> files = null;
			try {
				files = Thread.currentThread().getContextClassLoader().getResources(packagePath);
				while (files.hasMoreElements()) {
					URL url = files.nextElement();
					// /D:/IntelliJ%20IDEA%202020.3.4/code/maven/selfspring/target/classes/com/nick/selfspring
					// System.out.println("当前正在递归加载: url.getFile()" + url.getFile());
					// System.out.println("当前正在递归加载: url.getPath()" + url.getPath());
					//	查找此包下的类
					findPackageClasses(url.getFile(), basePackage);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void findPackageClasses(String packagePath, String basePackage) {
		if (packagePath.startsWith("/")) {
			packagePath = packagePath.substring(1);
		}
		if (packagePath.contains("%20")) {
			packagePath = packagePath.replaceAll("%20", " ");
		}
		File file = new File(packagePath);
		File[] classFiles = file.listFiles((pathname) -> {
			if (pathname.isDirectory() || pathname.getName().endsWith(".class")) {
				return true;
			}
			return false;
		});
		for (File cf : classFiles) {
			System.out.println("basePackage: " + basePackage);
			if (cf.isDirectory()) {
				findPackageClasses(cf.getAbsolutePath(), basePackage + "." + cf.getName());
			} else {
				URLClassLoader loader = new URLClassLoader(new URL[]{});
				Class cls = null;
				try {
					cls = loader.loadClass(basePackage + "." + cf.getName().replaceAll(".class", ""));
					//todo: 优化,看父注解是否有@NickComponent注解
					if (cls.isAnnotationPresent(NickComponent.class)
							|| cls.isAnnotationPresent(NickController.class)
							|| cls.isAnnotationPresent(NickService.class)
							|| cls.isAnnotationPresent(NickRepository.class)
							|| cls.isAnnotationPresent(NickConfiguration.class)) {
						logger.info("加载到一个待托管的类: " + cls.getName());
						//	包装成BeanDefinition
						NickBeanDefinition definition = new NickBeanDefinition();
						if (cls.isAnnotationPresent(NickLazy.class)) {
							definition.setLazy(true);
						}
						if (cls.isAnnotationPresent(NickScope.class)) {
							NickScope annotation = (NickScope) cls.getAnnotation(NickScope.class);
							String value = annotation.value();
							definition.setScope(value);
						}
						definition.setClassInfo(basePackage + "." + cf.getName().replaceAll(".class", ""));
						String beanId = getBeanId(cls);
						this.beanDefinitionMap.put(beanId, definition);
					}
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private String getBeanId(Class cls) {
		NickComponent nickComponent = (NickComponent) cls.getAnnotation(NickComponent.class);
		NickController nickController = (NickController) cls.getAnnotation(NickController.class);
		NickService nickService = (NickService) cls.getAnnotation(NickService.class);
		NickRepository nickRepository = (NickRepository) cls.getAnnotation(NickRepository.class);
		NickConfiguration nickConfiguration = (NickConfiguration) cls.getAnnotation(NickConfiguration.class);
		if (nickConfiguration != null) {
			//全路径名
			return cls.getName();
		}
		String beanId = null;
		if (nickComponent != null) {
			beanId = nickComponent.value();
		} else if (nickController != null) {
			beanId = nickController.value();
		} else if (nickService != null) {
			beanId = nickService.value();
		} else if (nickRepository != null) {
			beanId = nickRepository.value();
		}
		//注解上没有value属性值
		if (beanId == null || "".equalsIgnoreCase(beanId)) {
			String typename = cls.getSimpleName();
			//取类名做beanId(类名首字母小写)
			beanId = typename.substring(0, 1).toLowerCase() + typename.substring(1);
		}
		return beanId;
	}

	@Override
	public Object getBean(String beanId) {
		NickBeanDefinition definition = this.beanDefinitionMap.get(beanId);
		if (definition == null) {
			throw new RuntimeException("容器中没有加载此Bean");
		}
		String scope = definition.getScope();
		if ("prototype".equalsIgnoreCase(scope)) {
			Object obj = null;
			try {
				obj = Class.forName(definition.getClassInfo()).newInstance();
				//原型模式的bean不保存
				return obj;
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		if (this.beanMap.containsKey(beanId)) {
			return this.beanMap.get(beanId);
		}
		if (definition.isLazy()) {
			Object obj = null;
			try {
				obj = Class.forName(definition.getClassInfo()).newInstance();
				//懒加载的bean要保存
				this.beanMap.put(beanId, obj);
				return obj;
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}
