package com.education.ztu;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.DayOfWeek;
import java.time.Month;

public class DateTimeExample {
    public static void main(String[] args) {
        LocalDateTime labStartDateTime = LocalDateTime.of(2024, 12, 22, 10, 30, 0);
        System.out.println("Дата та час початку лабораторної: " + labStartDateTime);

        DayOfWeek dayOfWeek = labStartDateTime.getDayOfWeek();
        int dayOfYear = labStartDateTime.getDayOfYear();
        Month month = labStartDateTime.getMonth();
        int year = labStartDateTime.getYear();
        int hour = labStartDateTime.getHour();
        int minute = labStartDateTime.getMinute();
        int second = labStartDateTime.getSecond();

        System.out.println("День тижня: " + dayOfWeek);
        System.out.println("День у році: " + dayOfYear);
        System.out.println("Місяць: " + month);
        System.out.println("Рік: " + year);
        System.out.println("Години: " + hour);
        System.out.println("Хвилини: " + minute);
        System.out.println("Секунди: " + second);

        boolean isLeapYear = labStartDateTime.toLocalDate().isLeapYear();
        System.out.println("Чи рік високосний: " + (isLeapYear ? "Так" : "Ні"));

        LocalDateTime currentDateTime = LocalDateTime.now();
        System.out.println("Поточна дата та час: " + currentDateTime);

        if (currentDateTime.isAfter(labStartDateTime)) {
            System.out.println("Поточний час пізніше початку лабораторної.");
        } else if (currentDateTime.isBefore(labStartDateTime)) {
            System.out.println("Поточний час раніше початку лабораторної.");
        } else {
            System.out.println("Поточний час співпадає з початком лабораторної.");
        }

        LocalDateTime modifiedDateTime = labStartDateTime.plusDays(5).minusHours(2).withMinute(45);
        System.out.println("Змінена дата та час: " + modifiedDateTime);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
        System.out.println("Форматована змінена дата: " + modifiedDateTime.format(formatter));
    }
}
