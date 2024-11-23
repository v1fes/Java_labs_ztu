package com.education.ztu;

public class Task7 {
    public static void main(String[] args) {
        char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

        for (char letter : alphabet) {
            System.out.println(letter + " ==> " + (int) letter);
        }
    }
}
