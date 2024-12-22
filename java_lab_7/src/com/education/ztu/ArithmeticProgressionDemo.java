package com.education.ztu;

class ArithmeticProgression implements Runnable {
    private static int result = 1; // Статична змінна для збереження результату прогресії

    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            synchronized (ArithmeticProgression.class) { // Використання блоку синхронізації
                System.out.println(Thread.currentThread().getName() + ": " + result);
                result++;
            }
            try {
                Thread.sleep(200); // Чекати 0,2 секунди
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " було перервано.");
                return;
            }
        }
    }
}

public class ArithmeticProgressionDemo {
    public static void main(String[] args) {
        // Створення об'єкта Runnable
        ArithmeticProgression progressionTask = new ArithmeticProgression();

        // Створення трьох потоків
        Thread thread1 = new Thread(progressionTask, "Thread1");
        Thread thread2 = new Thread(progressionTask, "Thread2");
        Thread thread3 = new Thread(progressionTask, "Thread3");

        // Запуск потоків
        thread1.start();
        thread2.start();
        thread3.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            System.out.println("Головний потік було перервано.");
        }

        System.out.println("\nЗавершення роботи потоків.");
    }
}
