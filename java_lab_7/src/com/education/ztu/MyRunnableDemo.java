package com.education.ztu;

// Завдання 3: Створити клас, що реалізує інтерфейс Runnable
class MyRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i <= 10000; i++) {
            if (Thread.currentThread().isInterrupted()) {
                System.out.println(Thread.currentThread().getName() + ": Розрахунок завершено!!!");
                return;
            }
            if (i % 10 == 0) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        }
    }
}

public class MyRunnableDemo {
    public static void main(String[] args) {
        // Створення і запуск трьох потоків
        MyRunnable myRunnable = new MyRunnable();
        Thread thread1 = new Thread(myRunnable, "Thread1");
        Thread thread2 = new Thread(myRunnable, "Thread2");
        Thread thread3 = new Thread(myRunnable, "Thread3");

        thread1.start();
        thread2.start();
        thread3.start();

        try {
            // Зробити паузу на 2 секунди
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("Головний потік було перервано.");
        }

        // Перервати потоки
        thread1.interrupt();
        thread2.interrupt();
        thread3.interrupt();
    }
}
