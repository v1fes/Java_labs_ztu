package com.education.ztu;

import java.util.Scanner;

public class Task6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of Fibonacci elements: ");
        int n = scanner.nextInt();

        int[] fibonacci = new int[n];
        int[] reversedFibonacci = new int[n];

        if (n > 0)
            fibonacci[0] = 1;
        if (n > 1)
            fibonacci[1] = 1;

        for (int i = 2; i < n; i++) {
            fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
        }

        for (int i = 0; i < n; i++) {
            reversedFibonacci[i] = fibonacci[n - 1 - i];
        }

        System.out.println("Fibonacci sequence: " + arrayToString(fibonacci));
        System.out.println("Reversed Fibonacci sequence: " + arrayToString(reversedFibonacci));
        scanner.close();
    }

    private static String arrayToString(int[] array) {
        StringBuilder sb = new StringBuilder();
        for (int num : array) {
            sb.append(num).append(" ");
        }
        return sb.toString().trim();
    }

}
