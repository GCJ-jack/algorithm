package com.itheima.stream;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

public class OrderStatisticsDemo {
    // 商品类
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
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Product)) return false;
            Product product = (Product) o;
            return Objects.equals(name, product.name) &&
                    Objects.equals(category, product.category);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, category);
        }

        @Override
        public String toString() {
            return name + "【" + category + "】¥" + price;
        }
    }

    // 客户类
    static class Customer {
        private String name;
        private int tier;

        public Customer(String name, int tier) {
            this.name = name;
            this.tier = tier;
        }

        public int getTier() {
            return tier;
        }
    }

    // 订单类
    static class Order {
        private int id;
        private Customer customer;
        private LocalDate orderDate;
        private List<Product> products;

        public Order(int id, Customer customer, LocalDate orderDate, List<Product> products) {
            this.id = id;
            this.customer = customer;
            this.orderDate = orderDate;
            this.products = products;
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

        @Override
        public String toString() {
            return "订单ID: " + id +
                    ", 客户等级: " + customer.getTier() +
                    ", 下单日期: " + orderDate +
                    ", 商品列表: " + products;
        }
    }

    // 模拟订单数据
    public static List<Order> findAllOrders() {
        Customer c1 = new Customer("Alice", 2);
        Customer c2 = new Customer("Bob", 1);
        Customer c3 = new Customer("Charlie", 2);

        Product p1 = new Product("毛绒熊", "Toys", 100);
        Product p2 = new Product("拼图", "Toys", 80);
        Product p3 = new Product("奶瓶", "Baby", 50);
        Product p4 = new Product("Java 编程思想", "Books", 120);

        return Arrays.asList(
                new Order(1, c1, LocalDate.of(2021, 2, 15), Arrays.asList(p1, p2, p4)), // ✅
                new Order(2, c2, LocalDate.of(2021, 3, 1), Arrays.asList(p2)),         // ❌ Tier 不对
                new Order(3, c3, LocalDate.of(2021, 4, 1), Arrays.asList(p1, p3)),     // ❌ 日期不对
                new Order(4, c1, LocalDate.of(2021, 1, 25), Arrays.asList(p4))  ,       // ❌ 日期不对
                new Order(4, c1, LocalDate.of(2021, 3, 15), Arrays.asList(p4,p1,p2))
        );
    }

    public static void main(String[] args) {
//        double result = findAllOrders()
//            .stream()
//            .filter(order -> order.getOrderDate().compareTo(LocalDate.of(2021, 2, 1)) >= 0)
//            .filter(order -> order.getOrderDate().compareTo(LocalDate.of(2021, 3, 1)) < 0)
//            .flatMap(order -> order.getProducts().stream())
//            .peek(p -> System.out.println(p.getPrice()))
//            .mapToDouble(Product::getPrice)
//            .peek(d -> System.out.println(d))
//            .sum();


//        System.out.println(result);

//        double averagePrice = findAllOrders()
//                .stream()
//                .filter(order -> order.getOrderDate().isEqual(LocalDate.of(2021, 3, 15)))
//                .flatMap(order -> order.getProducts().stream())
//                .mapToDouble(Product::getPrice)
//                .average()
//                .getAsDouble();
//
//        System.out.println(averagePrice);

//        DoubleSummaryStatistics statistics = productRepo.findAll()
//                .stream()
//                .filter(p -> p.getCategory().equalsIgnoreCase("Books"))
//                .mapToDouble(Product::getPrice)
//                .summaryStatistics();

    }

}
