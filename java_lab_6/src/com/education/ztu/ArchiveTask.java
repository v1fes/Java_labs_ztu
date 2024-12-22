package com.education.ztu;

import java.io.*;
import java.util.zip.*;

public class ArchiveTask {

    public static void main(String[] args) throws IOException {
        // Шлях до головної папки
        File mainDirectory = new File("java_lab_6/directory_for_files");
        File zipFile = new File(mainDirectory, "archive.zip");

        // Створення архіву
        try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(zipFile))) {
            File[] files = mainDirectory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        try (FileInputStream fis = new FileInputStream(file)) {
                            ZipEntry zipEntry = new ZipEntry(file.getName());
                            zos.putNextEntry(zipEntry);

                            byte[] buffer = new byte[1024];
                            int bytesRead;
                            while ((bytesRead = fis.read(buffer)) != -1) {
                                zos.write(buffer, 0, bytesRead);
                            }
                            zos.closeEntry();
                        }
                    }
                }
            }
        }
        System.out.println("Файли успішно додані до архіву.");

        // Виведення списку файлів з архіву
        try (ZipInputStream zis = new ZipInputStream(new FileInputStream(zipFile))) {
            System.out.println("Список файлів у архіві:");
            ZipEntry zipEntry;
            while ((zipEntry = zis.getNextEntry()) != null) {
                System.out.println("- " + zipEntry.getName());
            }
        }
    }
}