package com.heima;

import java.util.ServiceLoader;

public class Consumer {
    public static void main(String[] args) {

        ServiceLoader<Service> serviceLoader = ServiceLoader.load(Service.class);

        // 遍历加载到的所有实现类，并执行它们的功能
        for (Service service : serviceLoader) {
            service.execute();  // 调用每个实现类的 execute 方法
        }
    }
}
