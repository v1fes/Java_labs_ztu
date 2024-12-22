package com.education.ztu;

import java.util.function.Consumer;

public class ConsumerExample {
    public static void main(String[] args) {
        // Лямбда вираз для повідомлення про початок і закінчення пари
        Consumer<String> startLecture = str -> System.out.println("Пара почалася о 8:30");
        Consumer<String> endLecture = str -> System.out.println("Пара закінчилася о 9:50");

        // Використання методу andThen
        Consumer<String> lectureSchedule = startLecture.andThen(endLecture);

        // Виклик
        lectureSchedule.accept("Пропущений рядок, але він не використовується");
    }
}
