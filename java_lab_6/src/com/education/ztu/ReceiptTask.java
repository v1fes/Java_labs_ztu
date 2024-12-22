package com.education.ztu;

import java.io.*;
import java.util.Formatter;

public class ReceiptTask {

    public static void main(String[] args) throws IOException {
        // Створення папки для файлів
        File directory = new File("java_lab_6/directory_for_files");
        if (!directory.exists()) {
            directory.mkdirs();
        }

        // Завдання: Формування звіту з лаби 4
        String[][] items = new String[][]{{"1.", "Джинси", "Жіночий одяг", "1500,78 ₴"},
                {"2.", "Спідниця", "Жіночий одяг", "1000,56 ₴"},
                {"3.", "Краватка", "Чоловічий одяг", "500,78 ₴"},
                {"4.", "Сорочка", "Чоловічий одяг", "750,40 ₴"},
                {"5.", "Куртка", "Жіночий одяг", "2000,00 ₴"},
                {"6.", "Шапка", "Аксесуари", "300,00 ₴"},
                {"7.", "Ремінь", "Аксесуари", "450,25 ₴"},
                {"8.", "Штани", "Чоловічий одяг", "1200,99 ₴"},
                {"9.", "Сукня", "Жіночий одяг", "1800,00 ₴"},
                {"10.", "Пальто", "Жіночий одяг", "2500,50 ₴"}};
        double total = 12004.26;

        // Запис звіту у файл
        File reportFile = new File(directory, "report.txt");
        try (FileWriter writer = new FileWriter(reportFile)) {
            Formatter formatter = new Formatter(writer);
            formatter.format("Дата та час покупки:    %s\n", "28.03.2019 13:25:12");
            formatter.format("===========================================\n");
            formatter.format("%-4s %-12s %-15s %-10s\n", "№", "Товар", "Категорія", "Ціна");
            formatter.format("===========================================\n");

            for (String[] item : items) {
                formatter.format("%-4s %-12s %-15s %-10s\n", item[0], item[1], item[2], item[3]);
            }

            formatter.format("===========================================\n");
            formatter.format("%-30s %10.2f ₴\n", "Разом:", total);
            formatter.close();
        }

        // Читання звіту з файлу
        try (FileReader reader = new FileReader(reportFile);
             BufferedReader bufferedReader = new BufferedReader(reader)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        }
    }
}
