package com.itheima.stream;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class StreamFilterTest {

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

        public String getName() { return name; }
        public String getCategory() { return category; }
        public double getPrice() { return price; }

        @Override
        public String toString() {
            return name + " - " + category + " - $" + price;
        }
    }

    // Order 类
    static class Order {
        private int id;
        private List<Product> products;

        public Order(int id, List<Product> products) {
            this.id = id;
            this.products = products;
        }

        public int getId() { return id; }
        public List<Product> getProducts() { return products; }

        @Override
        public String toString() {
            return "Order #" + id + ": " + products;
        }
    }


    // 模拟 productRepo.findAll()
    public static List<Product> findAll() {
        return Arrays.asList(
                new Product("Java 编程思想", "Books", 120),
                new Product("Effective Java", "Books", 95),
                new Product("MacBook Pro", "Electronics", 1500),
                new Product("数据结构与算法", "Books", 130),
                new Product("鼠标", "Electronics", 80)
        );
    }

    // 模拟订单仓库
    public static List<Order> findAllOrders() {
        // Books 类商品
        Product p1 = new Product("Java 编程思想", "Books", 120);
        Product p2 = new Product("Effective Java", "Books", 95);
        Product p3 = new Product("MacBook Pro", "Electronics", 1500);
        Product p4 = new Product("数据结构与算法", "Books", 130);

        // Baby 类商品
        Product p5 = new Product("奶瓶", "Baby", 35);
        Product p6 = new Product("婴儿床", "Baby", 400);
        Product p7 = new Product("尿不湿", "Baby", 100);

        // 创建订单（注意：有些包含 Baby 产品）
        return Arrays.asList(
                new Order(1, Arrays.asList(p1, p2)),           // 只有 Books
                new Order(2, Arrays.asList(p3)),                // Electronics
                new Order(3, Arrays.asList(p4, p5)),            // Books + Baby ✅
                new Order(4, Arrays.asList(p6, p1)),            // Baby + Books ✅
                new Order(5, Arrays.asList(p2, p7, p3))         // Books + Baby + Electronics ✅
        );
    }


    public static void main(String[] args) {

//        List<Product> list = findAll().stream().filter(product -> product.getCategory().equals("Books")).filter(product -> product.price > 100).collect(Collectors.toList());
//
//        list.forEach(System.out::println);


        List<Order> list = findAllOrders().stream().filter(order -> order.getProducts().stream().anyMatch(product -> product.category.equalsIgnoreCase("Baby"))).collect(Collectors.toList());

        list.forEach(System.out::println);
    }


}
