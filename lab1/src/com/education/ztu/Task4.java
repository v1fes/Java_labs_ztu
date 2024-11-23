package com.education.ztu;

import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first positive integer: ");
        int a = scanner.nextInt();
        System.out.print("Enter the second positive integer: ");
        int b = scanner.nextInt();

        System.out.println("The greatest common divisor is: " + gcd(a, b));
        scanner.close();
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
