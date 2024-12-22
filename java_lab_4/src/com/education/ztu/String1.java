package com.education.ztu;

public class String1 {
    public static void main(java.lang.String[] args) {
        // Створення рядка
        java.lang.String inputString = "I learn Java!!!";

        // Роздрукувати останній символ рядка
        System.out.println("Останній символ рядка: " + inputString.charAt(inputString.length() - 1));

        // Перевірити, чи закінчується рядок підрядком "!!!"
        System.out.println("Чи закінчується рядок '!!!': " + inputString.endsWith("!!!"));

        // Перевірити, чи починається рядок підрядком "I learn "
        System.out.println("Чи починається рядок 'I learn ': " + inputString.startsWith("I learn "));

        // Перевірити, чи містить рядок підрядок "Java"
        System.out.println("Чи містить рядок 'Java': " + inputString.contains("Java"));

        // Знайти позицію підрядка "Java" у рядку
        System.out.println("Позиція підрядка 'Java': " + inputString.indexOf("Java"));

        // Замінити всі символи "а" на "о"
        java.lang.String replacedString = inputString.replace('a', 'o');
        System.out.println("Рядок після заміни 'a' на 'o': " + replacedString);

        // Перетворити рядок на верхній регістр
        System.out.println("Рядок у верхньому регістрі: " + inputString.toUpperCase());

        // Перетворити рядок на нижній регістр
        System.out.println("Рядок у нижньому регістрі: " + inputString.toLowerCase());

        // Вирізати рядок "Java"
        java.lang.String cutString = inputString.substring(inputString.indexOf("Java"), inputString.indexOf("Java") + 4);
        System.out.println("Вирізаний рядок 'Java': " + cutString);
    }
}
