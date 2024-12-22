package com.education.ztu;

import com.education.ztu.game.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main2 {
    public static void main(String[] args) {
        List<Participant> participants = new ArrayList<>();
        participants.add(new Student("Mykola", 20));
        participants.add(new Student("Viktoria", 21));
        participants.add(new Student("Andriy", 22));
        participants.add(new Student("Oksana", 19));
        participants.add(new Student("Mykola", 18));

        System.out.println("Sorting by name (Comparable):");
        participants.sort(null);
        participants.forEach(System.out::println);

        System.out.println("\\nSorting by age (Comparator):");
        participants.sort(Comparator.comparingInt(Participant::getAge));
        participants.forEach(System.out::println);

        System.out.println("\\nSorting by name and then by age (Java 8 Comparator):");
        participants.sort(Comparator.comparing(Participant::getName).thenComparing(Participant::getAge));
        participants.forEach(System.out::println);
    }
}