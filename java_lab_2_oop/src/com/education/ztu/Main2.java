package com.education.ztu;

public class Main2 {
    public static void main(String[] args) {
        System.out.println("Addition: " + Operation.addition(1, 2, 3, 4, 5));
        System.out.println("Subtraction: " + Operation.subtraction(20, 5, 3));
        System.out.println("Multiplication: " + Operation.multiplication(2, 3, 4));
        System.out.println("Division: " + Operation.division(100, 2, 5));
        System.out.println("Average: " + Operation.average(10, 20, 30, 40, 50));
        System.out.println("Maximum: " + Operation.maximum(1, 3, 7, 0, -5));
        System.out.println("Minimum: " + Operation.minimum(1, 3, 7, 0, -5));

        System.out.println("All Locations:");
        for (Location loc : Location.values()) {
            System.out.println(loc);
        }
    }
}
