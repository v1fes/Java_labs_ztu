package com.education.ztu;

import com.education.ztu.game.*;

public class Main {
    public static void main(String[] args) {
        // Creating participants
        Student student1 = new Student("Mykola", 20);
        Student student2 = new Student("Viktoria", 21);
        Student student3 = new Student("Mykola", 20); // Same properties as student1

        // Demonstrating equals and hashCode
        System.out.println("student1 equals student2: " + student1.equals(student2)); // false
        System.out.println("student1 equals student3: " + student1.equals(student3)); // true
        System.out.println("student1 hashCode: " + student1.hashCode());
        System.out.println("student3 hashCode: " + student3.hashCode());

        // Demonstrating toString
        System.out.println("student1: " + student1);
        System.out.println("student2: " + student2);

        // Cloning participants
        Student clonedStudent = (Student) student1.clone();
        System.out.println("Cloned student: " + clonedStudent);

        // Creating and cloning a team
        Team<Student> studentTeam = new Team<>("Vpered");
        studentTeam.addNewParticipant(student1);
        studentTeam.addNewParticipant(student2);

        System.out.println("Original team: " + studentTeam);
        Team<Student> clonedTeam = studentTeam.deepClone();
        System.out.println("Cloned team: " + clonedTeam);

        // Modifying the cloned team to ensure deep copy
        clonedTeam.addNewParticipant(new Student("Oksana", 22));
        System.out.println("Modified cloned team: " + clonedTeam);
        System.out.println("Original team after modifying cloned team: " + studentTeam);
    }
}