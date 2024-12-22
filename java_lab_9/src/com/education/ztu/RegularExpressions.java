package com.education.ztu;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressions {
    public static void main(String[] args) {
        // Вхідний текст із даними співробітників
        String employees = """
            1. Ivanov Ivan, 29, Developer, 5 years, Kyiv, ivanov.ivan@example.com, +380501234567
            2. Petrenko Petro, 35, Manager, 10 years, Lviv, petrenko.p@example.com, +380671112233
            3. Sidorov Sidor, 28, Designer, 3 years, Odessa, sidorov.s@example.com, +380931234567
            4. Shevchenko Olga, 25, Tester, 2 years, Kharkiv, olga.shevchenko@example.com, +380503334455
            5. Kravchenko Andriy, 40, Architect, 15 years, Dnipro, andriy.kravchenko@example.com, +380505556677
        """;

        // Знаходимо номери телефонів
        System.out.println("Номери телефонів:");
        Pattern phonePattern = Pattern.compile("\\+380\\d{9}");
        Matcher phoneMatcher = phonePattern.matcher(employees);
        while (phoneMatcher.find()) {
            System.out.println(phoneMatcher.group());
        }

        // Знаходимо емейли
        System.out.println("\nЕмайли:");
        Pattern emailPattern = Pattern.compile("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}");
        Matcher emailMatcher = emailPattern.matcher(employees);
        while (emailMatcher.find()) {
            System.out.println(emailMatcher.group());
        }

        // Змінюємо формат дат народження (приклад: замінюємо вигадану дату)
        System.out.println("\nЗміна формату дат народження:");
        String textWithDates = "Ivanov Ivan, народився 20.05.1995";
        String updatedDates = textWithDates.replaceAll("(\\d{2})\\.(\\d{2})\\.(\\d{4})", "$3-$2-$1");
        System.out.println(updatedDates);

        // Змінюємо посади кільком співробітникам
        System.out.println("\nЗміна посад:");
        String updatedPositions = employees.replaceAll("Developer", "Senior Developer")
                .replaceAll("Tester", "QA Engineer");
        System.out.println(updatedPositions);
    }
}
