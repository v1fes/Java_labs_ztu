package com.education.ztu;

public class Main {
    // Завдання 2: Метод перевірки логіну та паролю
    public static boolean checkCredentials(String login, String password, String confirmPassword) {
        try {
            if (!login.matches("[a-zA-Z0-9_]{1,19}")) {
                throw new WrongLoginException("Login must contain only latin letters, numbers, underscores, and be less than 20 characters.");
            }
            if (!password.matches("[a-zA-Z0-9_]{1,19}") || !password.equals(confirmPassword)) {
                throw new WrongPasswordException("Password must meet requirements and match confirmPassword.");
            }
            return true;
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }

    public static void main(String[] args) {
        // Завдання 2: Перевірка логіну та паролю
        System.out.println(checkCredentials("valid_user", "password123", "password123")); // true
        System.out.println(checkCredentials("invalid user", "password123", "password123")); // false
    }
}
class WrongLoginException extends Exception {
    public WrongLoginException() {
        super("Invalid login");
    }

    public WrongLoginException(String message) {
        super(message);
    }
}

class WrongPasswordException extends Exception {
    public WrongPasswordException() {
        super("Invalid password");
    }

    public WrongPasswordException(String message) {
        super(message);
    }
}
