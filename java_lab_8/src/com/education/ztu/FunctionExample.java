package com.education.ztu;

import java.util.function.Function;

public class FunctionExample {
    public static void main(String[] args) {
        // Лямбда вираз для обчислення добутку чисел у рядку
        Function<String, Integer> multiplyNumbers = str -> {
            String[] numbers = str.split(" ");
            int result = 1;
            for (String num : numbers) {
                result *= Integer.parseInt(num);
            }
            return result;
        };

        // Використання
        String numbers = "2 3 4";
        System.out.println("Добуток чисел: " + multiplyNumbers.apply(numbers));
    }
}
