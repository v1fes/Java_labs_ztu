package com.education.ztu;

import java.util.Arrays;
import java.util.Optional;

public class OptionalExample {
    public static void main(String[] args) {
        // Масив чисел
        Integer[] numbers = {15, 42, 7, 23, 64, 5};

        // Знайти максимальне значення з масиву
        Optional<Integer> maxNumber = Arrays.stream(numbers).max(Integer::compare);

        // Використання Optional для перевірки наявності максимального значення
        String result = maxNumber.map(String::valueOf).orElse("Числа відсутні");

        // Вивід результату
        System.out.println("Максимальне значення: " + result);

        // Тест із порожнім масивом
        Integer[] emptyArray = {};
        Optional<Integer> emptyMax = Arrays.stream(emptyArray).max(Integer::compare);
        String emptyResult = emptyMax.map(String::valueOf).orElse("Числа відсутні");
        System.out.println("Результат для порожнього масиву: " + emptyResult);
    }
}
