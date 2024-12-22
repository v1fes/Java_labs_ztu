package com.education.ztu;

import java.io.*;

public class Copyfiles {

    public static void main(String[] args) throws IOException {
        // Шлях до вхідного та вихідного файлів
        File sourceTextFile = new File("java_lab_6/directory_for_files/report.txt");
        File targetTextFile = new File("java_lab_6/directory_for_files/copy_report.txt");

        File sourceImageFile = new File("java_lab_6/directory_for_files/eepy.jpg");
        File targetImageFile = new File("java_lab_6/directory_for_files/copy_eepy.jpg");

        // Копіювання текстового файлу
        try (BufferedReader reader = new BufferedReader(new FileReader(sourceTextFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(targetTextFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }
        }
        System.out.println("Текстовий файл скопійовано успішно.");

        // Копіювання зображення
        try (FileInputStream inputStream = new FileInputStream(sourceImageFile);
             FileOutputStream outputStream = new FileOutputStream(targetImageFile)) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
        }
        System.out.println("Зображення скопійовано успішно.");
    }
}