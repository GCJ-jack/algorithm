package com.heima;

import com.heima.annotation.Component;
import com.heima.annotation.PostConstruct;

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

public class ApplicationContext {

    private final Map<String,BeanDefinition> beanDefinitionMap = new HashMap<>();


    private final Map<String, Object> ioc = new HashMap<>();

    private final Map<String, Object> loadingIoc = new HashMap<>();

    private final List<BeanPostProcessor> beanPostProcessors = new ArrayList<>();


    public void initContext(String packageName) throws Exception{
        scanPackage(packageName);
    }


    private List<Class<?>> scanPackage(String packageName) throws Exception{
        List<Class<?>> classList  = new ArrayList<>();
        URL resource = this.getClass().getClassLoader().getResource(packageName.replace(File.separator,"."));

        Path path = Path.of(resource.toURI());

        Files.walkFileTree(path, new SimpleFileVisitor<>(){
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
                Path absolutePath = file.toAbsolutePath();
                if (absolutePath.toString().endsWith(".class")) {
                    String replaceStr = absolutePath.toString().replace(File.separator, ".");
                    int packageIndex = replaceStr.indexOf(packageName);
                    String className = replaceStr.substring(packageIndex, replaceStr.length() - ".class".length());
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

    protected Object getBean(Class<?> beanDefinition){
        String name = beanDefinition.getName();

        if(ioc.containsKey(name)){
            return ioc.get(name);
        }

        Object bean = this.ioc.get(name);

        if(bean != null){
            return bean;
        }

        if (beanDefinitionMap.containsKey(name)) {
            return createBean(beanDefinitionMap.get(name));
        }
        return null;
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





}
