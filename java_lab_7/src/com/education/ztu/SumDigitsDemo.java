package com.education.ztu;

import java.util.Random;
import java.util.concurrent.*;

public class SumDigitsDemo {

    private static final int ARRAY_SIZE = 1_000_000;
    private static final int THREAD_COUNT = 5;

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // Заповнення масиву випадковими числами
        int[] numbers = new int[ARRAY_SIZE];
        Random random = new Random();
        for (int i = 0; i < ARRAY_SIZE; i++) {
            numbers[i] = random.nextInt(1000); // Числа від 0 до 999
        }

        // Однопоточне виконання
        long singleThreadStart = System.currentTimeMillis();
        long singleThreadSum = calculateSumSingleThread(numbers);
        long singleThreadEnd = System.currentTimeMillis();

        System.out.println("Однопоточна сума: " + singleThreadSum);
        System.out.println("Час виконання (однопотоковий): " + (singleThreadEnd - singleThreadStart) + " мс");

        // Багатопоточне виконання
        long multiThreadStart = System.currentTimeMillis();
        long multiThreadSum = calculateSumMultiThread(numbers);
        long multiThreadEnd = System.currentTimeMillis();

        System.out.println("Багатопоточна сума: " + multiThreadSum);
        System.out.println("Час виконання (багатопотоковий): " + (multiThreadEnd - multiThreadStart) + " мс");
    }

    private static long calculateSumSingleThread(int[] numbers) {
        long sum = 0;
        for (int number : numbers) {
            sum += sumDigits(number);
        }
        return sum;
    }

    private static long calculateSumMultiThread(int[] numbers) throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);
        int chunkSize = ARRAY_SIZE / THREAD_COUNT;
        Future<Long>[] futures = new Future[THREAD_COUNT];

        for (int i = 0; i < THREAD_COUNT; i++) {
            int start = i * chunkSize;
            int end = (i == THREAD_COUNT - 1) ? ARRAY_SIZE : (i + 1) * chunkSize;
            futures[i] = executor.submit(new SumTask(numbers, start, end));
        }

        long totalSum = 0;
        for (Future<Long> future : futures) {
            totalSum += future.get();
        }

        executor.shutdown();
        return totalSum;
    }

    private static int sumDigits(int number) {
        int sum = 0;
        while (number != 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }

    static class SumTask implements Callable<Long> {
        private final int[] numbers;
        private final int start;
        private final int end;

        public SumTask(int[] numbers, int start, int end) {
            this.numbers = numbers;
            this.start = start;
            this.end = end;
        }

        @Override
        public Long call() {
            long sum = 0;
            for (int i = start; i < end; i++) {
                sum += sumDigits(numbers[i]);
            }
            return sum;
        }
    }
}
