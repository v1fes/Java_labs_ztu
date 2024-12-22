package com.education.ztu;

import java.util.Scanner;

class SharedData {
    private String data;
    private boolean hasData = false;

    public synchronized void writeData(String input) {
        while (hasData) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Writer потік було перервано.");
            }
        }
        data = input;
        hasData = true;
        notify();
    }

    public synchronized String readData() {
        while (!hasData) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Reader потік було перервано.");
            }
        }
        hasData = false;
        notify();
        return data;
    }
}

class Reader implements Runnable {
    private final SharedData sharedData;

    public Reader(SharedData sharedData) {
        this.sharedData = sharedData;
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Введіть текст (або 'exit' для завершення): ");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("exit")) {
                sharedData.writeData("exit");
                break;
            }
            sharedData.writeData(input);
            try {
                Thread.sleep(1000); // Заснути на 1 секунду
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Reader потік було перервано.");
            }
        }
        scanner.close();
    }
}

class Printer implements Runnable {
    private final SharedData sharedData;

    public Printer(SharedData sharedData) {
        this.sharedData = sharedData;
    }

    @Override
    public void run() {
        while (true) {
            String data = sharedData.readData();
            if (data.equalsIgnoreCase("exit")) {
                break;
            }
            System.out.println("Printer отримав: " + data);
        }
    }
}

public class ReaderPrinterDemo {
    public static void main(String[] args) {
        SharedData sharedData = new SharedData();

        Thread readerThread = new Thread(new Reader(sharedData), "Reader");
        Thread printerThread = new Thread(new Printer(sharedData), "Printer");

        readerThread.start();
        printerThread.start();

        try {
            readerThread.join();
            printerThread.join();
        } catch (InterruptedException e) {
            System.out.println("Головний потік було перервано.");
        }

        System.out.println("Завершення роботи програми.");
    }
}
