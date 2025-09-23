package com.heima;

import com.heima.annotation.Component;

import java.io.File;
import java.net.URL;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ApplicationContext {

    private final Map<String,BeanDefinition> beanDefinitionMap = new HashMap<>();

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

}
