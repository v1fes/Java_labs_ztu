package com.education.ztu;

import java.util.*;
import java.util.stream.Collectors;

class Product {
    private String name;
    private String brand;
    private double price;
    private int count;

    public Product(String name, String brand, double price, int count) {
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.count = count;
    }

    // Гетери для полів
    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public double getPrice() {
        return price;
    }

    public int getCount() {
        return count;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", price=" + price +
                ", count=" + count +
                '}';
    }
}
public class StreamAPIWithMethodReferences {
    public static void main(String[] args) {
        // Створення масиву продуктів
        List<Product> products = Arrays.asList(
                new Product("Laptop", "Dell", 1500, 10),
                new Product("Phone", "Samsung", 800, 5),
                new Product("TV", "Sony", 1200, 2),
                new Product("Headphones", "Sony", 200, 15),
                new Product("Smartwatch", "Apple", 500, 8),
                new Product("Tablet", "Samsung", 700, 3)
        );

        // Отримати всі бренди та вивести в консоль (map)
        System.out.println("Всі бренди:");
        products.stream()
                .map(Product::getBrand) // Використання гетера
                .distinct()
                .forEach(System.out::println);

        // Отримати 2 товари ціна яких менше 1000 (filter, limit)
        System.out.println("\nТовари ціна яких менше 1000:");
        products.stream()
                .filter(product -> product.getPrice() < 1000) // Використання гетера
                .limit(2)
                .forEach(System.out::println);

        // Отримати суму всіх видів товарів, що є на складі (reduce)
        System.out.println("\nСума всіх видів товарів на складі:");
        int totalCount = products.stream()
                .map(Product::getCount) // Використання гетера
                .reduce(0, Integer::sum);
        System.out.println(totalCount);

        // Згрупувати товари по бренду (Collectors.groupingBy())
        System.out.println("\nТовари згруповані по бренду:");
        Map<String, List<Product>> groupedByBrand = products.stream()
                .collect(Collectors.groupingBy(Product::getBrand)); // Використання гетера
        groupedByBrand.forEach((brand, productList) -> {
            System.out.println("Бренд: " + brand);
            productList.forEach(System.out::println);
        });

        // Відсортувати товари за зростанням ціни та повернути масив (sorted, Collectors)
        System.out.println("\nТовари, відсортовані за зростанням ціни:");
        List<Product> sortedByPrice = products.stream()
                .sorted(Comparator.comparingDouble(Product::getPrice)) // Використання гетера
                .collect(Collectors.toList());
        sortedByPrice.forEach(System.out::println);

        // Додатково: знайти найдорожчий товар
        System.out.println("\nНайдорожчий товар:");
        products.stream()
                .max(Comparator.comparingDouble(Product::getPrice)) // Використання гетера
                .ifPresent(System.out::println);
    }
}
