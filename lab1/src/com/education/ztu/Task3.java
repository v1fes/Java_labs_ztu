package com.education.ztu;

public class Task3 {
    public static void main(String[] args) {
        if (args != null && args.length > 0) {
            String result = String.join(" ", args);
            System.out.println(result);
        } else {
            System.out.println("No arguments provided");
        }
    }
}
