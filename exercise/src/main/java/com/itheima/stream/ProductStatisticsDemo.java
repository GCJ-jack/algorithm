package com.itheima.stream;

import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.List;

public class ProductStatisticsDemo {
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

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return name + "【" + category + "】: ¥" + price;
        }
    }

    // 模拟产品仓库
    public static List<Product> findAllProducts() {
        return Arrays.asList(
                new Product("Java 编程思想", "Books", 120),
                new Product("Effective Java", "Books", 95),
                new Product("C++ Primer", "Books", 130),
                new Product("毛绒熊", "Toys", 80),
                new Product("拼图", "Toys", 60),
                new Product("奶瓶", "Baby", 50)
        );
    }

    public static void main(String[] args) {

        DoubleSummaryStatistics doubleSummaryStatistics = findAllProducts()
                .stream()
                .filter(product -> product.getCategory().equalsIgnoreCase("Books"))
                .mapToDouble(Product::getPrice)
                .summaryStatistics();


        System.out.println(doubleSummaryStatistics.getAverage());
    }

}
