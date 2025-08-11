package com.itheima.DesignPattern;

import com.itheima.DesignPattern.Facade.SmartAppliancesFacade;
import com.itheima.DesignPattern.Flyweight.AbstractBox;
import com.itheima.DesignPattern.Flyweight.BoxFactory;

public class Client {
    public static void main(String[] args) {
//        //创建外观对象
//        SmartAppliancesFacade facade = new SmartAppliancesFacade();
//        //客户端直接与外观对象进行交互
//        facade.say("打开家电");
//        facade.say("关闭家电");

        BoxFactory factory = BoxFactory.getInstance();

        AbstractBox i1 = factory.getBox("I");
        AbstractBox i2 = factory.getBox("I");
        AbstractBox l1 = factory.getBox("L");
        AbstractBox o1 = factory.getBox("O");

        // 功能演示：同一个“形状”，不同颜色（颜色是外部状态/可变参数）
        i1.display("蓝色");
        i1.display("红色");
        l1.display("绿色");
        o1.display("黄色");

        // 享元复用验证：同 key 取到的是同一对象
        System.out.println("i1 == i2 ? " + (i1 == i2)); // 期望 true
        System.out.println("i1.getShape() = " + i1.getShape());
    }
}
