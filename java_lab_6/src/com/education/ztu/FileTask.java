package com.education.ztu;

import java.io.*;

public class FileTask {

    public static void main(String[] args) throws IOException {
        // Шлях до головної папки
        File mainDirectory = new File("java_lab_6/directory_for_files");

        // Створення нової папки inner_directory
        File innerDirectory = new File(mainDirectory, "inner_directory");
        if (!innerDirectory.exists()) {
            innerDirectory.mkdir();
        }
        System.out.println("Абсолютний шлях до папки: " + innerDirectory.getAbsolutePath());

        // Виведення імені батьківської директорії
        System.out.println("Ім'я батьківської директорії: " + innerDirectory.getParent());

        // Створення двох текстових файлів
        File file1 = new File(innerDirectory, "file1.txt");
        File file2 = new File(innerDirectory, "file2.txt");
        file1.createNewFile();
        file2.createNewFile();

        // Видалення одного файлу
        if (file1.delete()) {
            System.out.println("Файл file1.txt успішно видалено.");
        } else {
            System.out.println("Не вдалося видалити файл file1.txt.");
        }

        // Перейменування папки
        File renamedDirectory = new File(mainDirectory, "renamed_inner_directory");
        if (innerDirectory.renameTo(renamedDirectory)) {
            System.out.println("Папка перейменована в renamed_inner_directory.");
        } else {
            System.out.println("Не вдалося перейменувати папку.");
        }

        // Виведення списку файлів та папок в directory_for_files
        System.out.println("Список файлів та папок у directory_for_files:");
        File[] files = mainDirectory.listFiles();
        if (files != null) {
            for (File file : files) {
                System.out.println("Ім'я: " + file.getName() + ", Тип: " + (file.isDirectory() ? "Папка" : "Файл") + ", Розмір: " + file.length() + " байт");
            }
        }
    }
}
