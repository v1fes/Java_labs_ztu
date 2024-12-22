package com.education.ztu;

public class MyThread extends Thread {

    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println("Потік у стані RUNNING: " + this.getName());
        for (int i = 0; i < 100; i++) {
            System.out.println("Я люблю програмувати!!! " + (i + 1));
        }
        System.out.println("Потік завершив роботу: " + this.getName());
    }

    public static void main(String[] args) {
        MyThread myThread = new MyThread("InitialThread");

        System.out.println("Потік у стані NEW: " + myThread.getName());
        System.out.println("Ім'я потоку: " + myThread.getName());
        System.out.println("Пріоритет потоку: " + myThread.getPriority());
        System.out.println("Чи є потік демоном: " + myThread.isDaemon());
        System.out.println("Чи живий потік: " + myThread.isAlive());

        myThread.setName("MyProgrammingThread");
        myThread.setPriority(Thread.MAX_PRIORITY);
        System.out.println("Оновлене ім'я потоку: " + myThread.getName());
        System.out.println("Оновлений пріоритет потоку: " + myThread.getPriority());

        myThread.start();

        try {
            myThread.join();
        } catch (InterruptedException e) {
            System.out.println("Потік було перервано.");
        }

        Thread mainThread = Thread.currentThread();
        System.out.println("Ім'я головного потоку: " + mainThread.getName());
        System.out.println("Пріоритет головного потоку: " + mainThread.getPriority());

        System.out.println("Чи живий потік: " + myThread.isAlive());
        System.out.println("Потік у стані TERMINATED: " + myThread.getName());
    }
}