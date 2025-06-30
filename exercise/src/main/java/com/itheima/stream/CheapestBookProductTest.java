package com.itheima.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CheapestBookProductTest {

    static class Product {
        private String name;
        private String category;
        private double price;

        public Product(String name, String category, double price) {
            this.name = name;
            this.category = category;
            this.price = price;
        }

        public String getCategory() { return category; }
        public double getPrice() { return price; }
        public String getName() { return name; }

        @Override
        public String toString() {
            return name + "【" + category + "】：¥" + price;
        }
    }

    // 模拟产品仓库
    public static List<Product> findAllProducts() {
        return Arrays.asList(
                new Product("Java 编程思想", "Books", 120),
                new Product("Effective Java", "Books", 95),
                new Product("MacBook", "Electronics", 10000),
                new Product("拼图", "Toys", 80),
                new Product("数据结构与算法", "Books", 95), // 同价书籍（测试用）
                new Product("毛绒熊", "Toys", 150)
        );
    }

    public static void main(String[] args) {

//        // 方法一：sorted + findFirst（较啰嗦）
//        Optional<Product> result1 = findAllProducts()
//                .stream()
//                .filter(p -> p.getCategory().equalsIgnoreCase("Books"))
//                .sorted(Comparator.comparing(Product::getPrice))
//                .findFirst();
//
//        System.out.println("📚 最便宜的书籍（方式一 - sorted+findFirst）:");
//        result1.ifPresent(System.out::println);
//
//        // 方法二：使用 min()（推荐）
//        Optional<Product> result2 = findAllProducts()
//                .stream()
//                .filter(p -> p.getCategory().equalsIgnoreCase("Books"))
//                .min(Comparator.comparing(Product::getPrice));
//
//        System.out.println("📚 最便宜的书籍（方式二 - min）:");
//        result2.ifPresent(System.out::println);
//
//        // ✅ 扩展：如果你想找出所有价格相同的最低价书籍
//        double minPrice = result2.map(Product::getPrice).orElse(Double.MAX_VALUE);
//
//        List<Product> cheapestBooks = findAllProducts()
//                .stream()
//                .filter(p -> p.getCategory().equalsIgnoreCase("Books"))
//                .filter(p -> p.getPrice() == minPrice)
//                .collect(Collectors.toList());
//
//        System.out.println("📚 所有价格最低的书籍（可能多个）:");
//        cheapestBooks.forEach(System.out::println);

        //对比书本的价格
        Optional<Product> optional = findAllProducts().
                stream()
                .filter(o -> o.getCategory().equalsIgnoreCase("Books"))
                .sorted(Comparator.comparing(Product::getPrice))
                .findFirst();

        System.out.println(optional);


    }
}
