package com.education.ztu;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class ReceiptLangExample {
    public static void main(String[] args) {
        // Вибір мови
        Locale uaLocale = new Locale("uk", "UA");
        Locale enLocale = new Locale("en", "US");
        Locale frLocale = new Locale("fr", "FR");

        // Демонстрація трьох локалей
        printReceipt(uaLocale);
        printReceipt(enLocale);
        printReceipt(frLocale);
    }

    private static void printReceipt(Locale locale) {
        // Завантаження локалізованих ресурсів
        ResourceBundle bundle = ResourceBundle.getBundle("data", locale);

        // Дані про товари
        Object[][] items = {
                {1, "Джинси", "Жіночий одяг", 1500.78},
                {2, "Спідниця", "Жіночий одяг", 1000.56},
                {3, "Краватка", "Чоловічий одяг", 500.78}
        };

        // Форматування заголовка
        System.out.println(bundle.getString("header") + " " + bundle.getString("date"));
        System.out.println("===========================================");

        // Форматування колонок
        String[] columns = bundle.getString("columns").split(",");
        System.out.printf("%-4s %-12s %-15s %-10s\n", columns[0], columns[1], columns[2], columns[3]);
        System.out.println("===========================================");

        // Форматування товарів
        double total = 0;
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);

        for (Object[] item : items) {
            total += (double) item[3];
            System.out.printf("%-4d %-12s %-15s %-10s\n", item[0], item[1], item[2],
                    currencyFormatter.format(item[3]));
        }

        // Вивід загальної суми
        System.out.println("===========================================");
        System.out.printf("%-30s %10s\n", bundle.getString("total"), currencyFormatter.format(total));
        System.out.println();
    }
}
