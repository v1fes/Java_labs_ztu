package com.education.ztu;

import java.util.*;
public class Main {
    public static void main(String[] args) {
        // Завдання 3: Динамічний масив
        List<Product> productList = new ArrayList<>();
        productList.add(new Product("Laptop", 1500));
        productList.add(new Product("Smartphone", 800));
        productList.add(new Product("Tablet", 600));

        System.out.println("Initial list: " + productList);
        productList.add(1, new Product("Monitor", 300));
        System.out.println("After adding Monitor: " + productList);

        Product product = productList.get(2);
        System.out.println("Get element at index 2: " + product);

        int index = productList.indexOf(new Product("Tablet", 600));
        System.out.println("Index of Tablet: " + index);

        productList.set(2, new Product("Keyboard", 100));
        System.out.println("After setting Keyboard at index 2: " + productList);

        productList.sort(Comparator.comparing(Product::getPrice));
        System.out.println("Sorted list: " + productList);

        // Завдання 4: Черга
        ArrayDeque<Product> productQueue = new ArrayDeque<>();
        productQueue.offerLast(new Product("Laptop", 1500));
        productQueue.offerLast(new Product("Smartphone", 800));
        System.out.println("Queue: " + productQueue);

        Product first = productQueue.getFirst();
        System.out.println("First element: " + first);

        Product last = productQueue.pollLast();
        System.out.println("Removed last element: " + last);
        System.out.println("Queue after removal: " + productQueue);

        // Завдання 5: Множина
        TreeSet<Product> productSet = new TreeSet<>(Comparator.comparing(Product::getName));
        productSet.add(new Product("Laptop", 1500));
        productSet.add(new Product("Smartphone", 800));
        productSet.add(new Product("Tablet", 600));

        System.out.println("TreeSet: " + productSet);
        Product firstProduct = productSet.first();
        System.out.println("First product: " + firstProduct);

        // Завдання 6: Map
        Map<String, Product> productMap = new HashMap<>();
        productMap.put("Laptop", new Product("Laptop", 1500));
        productMap.put("Smartphone", new Product("Smartphone", 800));

        Product retrievedProduct = productMap.get("Laptop");
        System.out.println("Retrieved from Map: " + retrievedProduct);

        // Завдання 7: Collections
        List<Product> arrayList = Arrays.asList(
                new Product("Item1", 200),
                new Product("Item2", 300),
                new Product("Item3", 100)
        );

        Collections.sort(arrayList, Comparator.comparing(Product::getPrice));
        System.out.println("Sorted list: " + arrayList);

        int indexBinarySearch = Collections.binarySearch(arrayList, new Product("Item2", 300), Comparator.comparing(Product::getPrice));
        System.out.println("Binary search index of Item2: " + indexBinarySearch);
    }
}
