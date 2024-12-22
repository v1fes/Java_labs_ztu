package com.education.ztu;

import java.util.function.Supplier;

public class SupplierExample {
    public static void main(String[] args) {
        // Лямбда вираз для виведення речення у верхньому регістрі
        Supplier<String> upperCaseSentence = () -> "Це речення у верхньому регістрі".toUpperCase();

        // Виклик
        System.out.println(upperCaseSentence.get());
    }
}
