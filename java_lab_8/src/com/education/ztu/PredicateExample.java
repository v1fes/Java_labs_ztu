package com.education.ztu;

import java.util.function.Predicate;

public class PredicateExample {
    public static void main(String[] args) {
        // Лямбда вираз для перевірки, чи рядок можна привести до числа
        Predicate<String> isNumeric = str -> {
            try {
                Double.parseDouble(str);
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        };

        // Використання Predicate і методу and()
        Predicate<String> notEmpty = str -> !str.isEmpty();
        Predicate<String> validNumber = isNumeric.and(notEmpty);

        // Перевірка рядків
        String testString = "123.45";
        System.out.println("Рядок \"" + testString + "\" є числом: " + validNumber.test(testString));

        testString = "abc";
        System.out.println("Рядок \"" + testString + "\" є числом: " + validNumber.test(testString));
    }
}
