package com.itheima.stream;

import java.util.*;
import java.util.stream.Collectors;

public class DiscountToyProductTest {

    // Product 类定义
    static class Product {
        private String name;
        private String category;
        private double price;

        public Product(String name, String category, double price) {
            this.name = name;
            this.category = category;
            this.price = price;
        }

        public String getCategory() {
            return category;
        }

        public double getPrice() {
            return price;
        }

        public Product withPrice(double newPrice) {
            return new Product(this.name, this.category, newPrice);
        }

        @Override
        public String toString() {
            return name + "【" + category + "】" + "：¥" + String.format("%.2f", price);
        }
    }

    // 模拟产品仓库
    public static List<Product> findAllProducts() {
        return Arrays.asList(
                new Product("遥控车", "Toys", 200),
                new Product("拼图", "Toys", 80),
                new Product("奶瓶", "Baby", 35),
                new Product("Java 编程思想", "Books", 120),
                new Product("毛绒熊", "Toys", 150),
                new Product("MacBook Pro", "Electronics", 12000)
        );
    }

    public static void main(String[] args) {
        List<Product> discountedToys = findAllProducts()
                .stream()
                .filter(p -> p.getCategory().equalsIgnoreCase("Toys"))
                .map(p -> p.withPrice(p.getPrice() * 0.9)) // 9 折
                .collect(Collectors.toList());

        System.out.println("🎁 打 9 折后的玩具产品列表：");
        discountedToys.forEach(System.out::println);
    }
}
