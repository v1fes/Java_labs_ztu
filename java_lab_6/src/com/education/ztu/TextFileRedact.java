package com.education.ztu;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class TextFileRedact {

    public static void main(String[] args) throws IOException {
        // Шлях до текстового файлу
        File textFile = new File("java_lab_6/directory_for_files/reportredact.txt");

        // Дописування тексту в файл
        try (RandomAccessFile raf = new RandomAccessFile(textFile, "rw")) {
            // Вставити текст на початок файлу
            raf.seek(0);
            String firstEntry = "Новий запис на початку файлу\n";
            insertTextAtPosition(raf, firstEntry);

            // Вставити текст в середину файлу
            long middlePosition = raf.length() / 2;
            raf.seek(middlePosition);
            String middleEntry = "\nЗапис в середині файлу\n";
            insertTextAtPosition(raf, middleEntry);

            // Вставити текст в кінець файлу
            raf.seek(raf.length());
            String endEntry = "\nНовий запис в кінці файлу\n";
            raf.write(endEntry.getBytes(StandardCharsets.UTF_8));
        }

        System.out.println("Текст успішно дописано в файл.");
    }

    private static void insertTextAtPosition(RandomAccessFile raf, String text) throws IOException {
        long currentPosition = raf.getFilePointer();
        byte[] remainingBytes = new byte[(int) (raf.length() - currentPosition)];
        raf.read(remainingBytes);

        raf.seek(currentPosition);
        raf.write(text.getBytes(StandardCharsets.UTF_8));
        raf.write(remainingBytes);
    }
}