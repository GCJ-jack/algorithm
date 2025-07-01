package com.itheima.stream;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class OrderRepo {

    static class Product {
        private String name;
        private String category;
        private double price;

        public Product(String name, String category, double price) {
            this.name = name;
            this.category = category;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public String getCategory() {
            return category;
        }

        public double getPrice() {
            return price;
        }
    }

    static class Customer {
        private String name;
        private int tier;

        public Customer(String name, int tier) {
            this.name = name;
            this.tier = tier;
        }

        public String getName() {
            return name;
        }

        public int getTier() {
            return tier;
        }
    }

    static class Order {
        private Long id;
        private Customer customer;
        private LocalDate orderDate;
        private List<Product> products;

        public Order(Long id, Customer customer, LocalDate orderDate, List<Product> products) {
            this.id = id;
            this.customer = customer;
            this.orderDate = orderDate;
            this.products = products;
        }

        public Long getId() {
            return id;
        }

        public Customer getCustomer() {
            return customer;
        }

        public LocalDate getOrderDate() {
            return orderDate;
        }

        public List<Product> getProducts() {
            return products;
        }
    }



    public static List<Order> findAll() {
        Customer c1 = new Customer("Alice", 2);
        Customer c2 = new Customer("Bob", 1);

        Product p1 = new Product("Java 编程思想", "Books", 120);
        Product p2 = new Product("拼图", "Toys", 80);
        Product p3 = new Product("奶瓶", "Baby", 50);
        Product p4 = new Product("C++ Primer", "Books", 130);

        return Arrays.asList(
                new Order(1L, c1, LocalDate.of(2021, 2, 15), Arrays.asList(p1, p2)),
                new Order(2L, c2, LocalDate.of(2021, 3, 1), Arrays.asList(p2, p3, p4)),
                new Order(3L, c1, LocalDate.of(2021, 4, 1), Collections.singletonList(p1))
        );
    }

    public static void main(String[] args) {

        Map<Long,Integer> map = findAll()
                .stream()
                .collect(
                        Collectors.toMap(
                            Order::getId,
                                order -> order.getProducts().size()
                        )
                );



        Map<String, List<Order>> groupMap = findAll().stream().
                collect(
                        Collectors.groupingBy(
                                order -> order.getCustomer().getName()
                        )
                );


        groupMap.forEach((name, orders) -> {
            System.out.println("客户名：" + name);
            orders.forEach(order -> System.out.println("  订单：" + order));
        });


    }
}
