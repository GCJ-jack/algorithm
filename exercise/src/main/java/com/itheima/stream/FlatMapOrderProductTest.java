package com.itheima.stream;

import java.security.PublicKey;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FlatMapOrderProductTest {
    static class Product {
        private String name;
        private String category;

        public Product(String name, String category) {
            this.name = name;
            this.category = category;
        }

        public String getName() { return name; }

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
            return name + "【" + category + "】";
        }
    }

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

        Product p1 = new Product("毛绒熊", "Toys");
        Product p2 = new Product("拼图", "Toys");
        Product p3 = new Product("奶瓶", "Baby");
        Product p4 = new Product("Java 编程思想", "Books");

        return Arrays.asList(
                new Order(1, c1, LocalDate.of(2021, 2, 15), Arrays.asList(p1, p2, p4)), // ✅
                new Order(2, c2, LocalDate.of(2021, 3, 1), Arrays.asList(p2)),         // ❌ Tier 不对
                new Order(3, c3, LocalDate.of(2021, 4, 1), Arrays.asList(p1, p3)),     // ✅
                new Order(4, c1, LocalDate.of(2021, 1, 25), Arrays.asList(p4))         // ❌ 日期不对
        );
    }

    public static void main(String[] args) {

        List<Product> list = findAllOrders().
                stream()
                .filter(order -> order.customer.tier == 2)
                .filter(order -> order.orderDate.compareTo(LocalDate.of(2021, 2, 1)) > 0)
                .filter(order -> order.orderDate.compareTo(LocalDate.of(2021,4,1)) < 0)
                .flatMap(order -> order.getProducts().stream())
                .distinct()
                .collect(Collectors.toList());

        list.forEach(System.out::println);

        List<Order> list1 = findAllOrders()
                .stream()
                .sorted(Comparator.comparing(Order::getOrderDate).reversed())
                .limit(3)
                .collect(Collectors.toList());

        list1.forEach(System.out::println);
    }
}
