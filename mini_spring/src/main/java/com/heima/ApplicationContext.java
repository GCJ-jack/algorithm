package com.heima;

import com.heima.annotation.Component;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;
import java.util.stream.Collectors;

public class ApplicationContext {

    private final Map<String,BeanDefinition> beanDefinitionMap = new HashMap<>();


    private final Map<String, Object> ioc = new HashMap<>();

    private final Map<String, Object> loadingIoc = new HashMap<>();

    private final List<BeanPostProcessor> beanPostProcessors = new ArrayList<>();

    public ApplicationContext(String name) throws Exception {
        initContext(name);
    }

    public void initContext(String packageName) throws Exception{
        scanPackage(packageName).stream().filter(this::canCreate).forEach(this::wrapper);
        initBeanPostProcessor();
        beanDefinitionMap.values().forEach(this::createBean);
    }

    private void initBeanPostProcessor(){
        beanDefinitionMap.values().stream()
                .filter(bd -> BeanPostProcessor.class.isAssignableFrom(bd.getBeanType()))
                .map(this::createBean)
                .map(BeanPostProcessor.class::cast)
                .forEach(beanPostProcessors::add);
    }


    private List<Class<?>> scanPackage(String packageName) throws Exception{
        List<Class<?>> classList  = new ArrayList<>();
        System.out.println("this is packagename " + packageName);
        URL resource = this.getClass().getClassLoader().getResource(packageName.replace(".",File.separator));
        System.out.println("this is url " + resource.toString());

        Path path = Path.of(resource.toURI());
        System.out.println("this is the path "  + path);
        Files.walkFileTree(path, new SimpleFileVisitor<>(){
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
                Path absolutePath = file.toAbsolutePath();
                System.out.println("walking tree absolute path" + absolutePath);
                if (absolutePath.toString().endsWith(".class")) {
                    String replaceStr = absolutePath.toString().replace(File.separator, ".");
                    int packageIndex = replaceStr.indexOf(packageName);

                    String className = replaceStr.substring(packageIndex, replaceStr.length() - ".class".length());
                    System.out.println("class name " + className );
                    try {
                        classList.add(Class.forName(className));
                    } catch (ClassNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                }

                return FileVisitResult.CONTINUE;
            }
        });

        return classList;
    }

    protected boolean canCreate(Class<?> clazz){
        return clazz.isAnnotationPresent(Component.class);
    }

    protected BeanDefinition wrapper(Class<?> clazz){
        BeanDefinition beanDefinition = new BeanDefinition(clazz);
        if(beanDefinitionMap.containsKey(beanDefinition)){
           throw new RuntimeException("bean 的名字已经重复");
        }
        beanDefinitionMap.put(beanDefinition.getName(),beanDefinition);
        return beanDefinition;
    }



    protected Object createBean(BeanDefinition beanDefinition){
        String name = beanDefinition.getName();
        if(ioc.containsKey(name)){
            return ioc.get(name);
        }

        if (loadingIoc.containsKey(name)) {
            return loadingIoc.get(name);
        }
        return doCreateBean(beanDefinition);
    }

    private Object doCreateBean(BeanDefinition beanDefinition) {

        //获取构造器
        Constructor constructor = beanDefinition.getConstructor();
        //返回值先是等于 null
        Object bean = null;
        try {
            //先通过构造器获得
            bean = constructor.newInstance();
            //放入 loading ioc 中
            loadingIoc.put(beanDefinition.getName(),bean);
            //自动注入
            autowiredBean(bean,beanDefinition);
            //初始化 bean
            initializeBean(bean,beanDefinition);
            //从 loading ioc 中移除
            loadingIoc.remove(beanDefinition.getName());
            //放入 ioc
            ioc.put(beanDefinition.getName(), bean);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return bean;

    }

    private Object initializeBean(Object bean, BeanDefinition beanDefinition) throws Exception {
        //先是before initialization
        for(BeanPostProcessor beanPostProcessor: beanPostProcessors){
            beanPostProcessor.beforeInitializeBean(bean,beanDefinition.getName());
        }
        //然后调用 post构造器
        Method postconstruct = beanDefinition.getPostConstructMethod();
        if(postconstruct!=null){
            postconstruct.invoke(bean);
        }
        //之后使用 after 初始化
        for (BeanPostProcessor postProcessor : beanPostProcessors) {
            bean = postProcessor.afterInitializeBean(bean, beanDefinition.getName());
        }

        return bean;
    }

    private void autowiredBean(Object bean, BeanDefinition beanDefinition) throws IllegalAccessException {
        for (Field autowriedField : beanDefinition.getAutowiredFields()) {
            autowriedField.setAccessible(true);
            autowriedField.set(bean, getBean(autowriedField.getType()));
        }
    }

    public Object getBean(String name) {
        if (name == null) {
            return null;
        }
        Object bean = this.ioc.get(name);
        if (bean != null) {
            return bean;
        }
        if (beanDefinitionMap.containsKey(name)) {
            return createBean(beanDefinitionMap.get(name));
        }
        return null;
    }

    public <T> T getBean(Class<T> beanType) {
        String beanName = this.beanDefinitionMap.values().stream()
                .filter(bd -> beanType.isAssignableFrom(bd.getBeanType()))
                .map(BeanDefinition::getName)
                .findFirst()
                .orElse(null);
        return (T) getBean(beanName);
    }

    public <T> List<T> getBeans(Class<T> beanType) {
        return this.beanDefinitionMap.values().stream()
                .filter(bd -> beanType.isAssignableFrom(bd.getBeanType()))
                .map(BeanDefinition::getName)
                .map(this::getBean)
                .map((bean) -> (T) bean)
                .collect(Collectors.toList());
    }

}
