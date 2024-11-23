package com.education.ztu;
import java.util.Arrays;

class Operation {
    public static int addition(int... values) {
        int sum = 0;
        for (int value : values) {
            sum += value;
        }
        return sum;
    }

    public static int subtraction(int... values) {
        int result = values[0];
        for (int i = 1; i < values.length; i++) {
            result -= values[i];
        }
        return result;
    }

    public static int multiplication(int... values) {
        int result = 1;
        for (int value : values) {
            result *= value;
        }
        return result;
    }

    public static double division(int... values) {
        double result = values[0];
        for (int i = 1; i < values.length; i++) {
            if (values[i] != 0) {
                result /= values[i];
            } else {
                throw new ArithmeticException("Division by zero");
            }
        }
        return result;
    }

    public static double average(int... values) {
        int sum = addition(values);
        return (double) sum / values.length;
    }

    public static int maximum(int... values) {
        int max = values[0];
        for (int value : values) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }

    public static int minimum(int... values) {
        int min = values[0];
        for (int value : values) {
            if (value < min) {
                min = value;
            }
        }
        return min;
    }
}