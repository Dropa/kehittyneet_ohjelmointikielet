package com.tasks2;

import java.util.concurrent.ThreadLocalRandom;

public class Statistics {
    public static void main(String[] args) {
        double[] numbers = Statistics.valueTable();
        System.out.print("Numbers: ");

        for (double number : numbers) {
            System.out.print(number + " ");
        }
        System.out.print("\n");

        System.out.print("sum: " + Statistics.sum(numbers) + "\n");
        System.out.print("min: " + Statistics.min(numbers) + "\n");
        System.out.print("max: " + Statistics.max(numbers) + "\n");
        System.out.print("avg: " + Statistics.avg(numbers) + "\n");
    }

    public static double sum(double[] numbers) {
        double sum = 0;
        for (double number : numbers) {
            sum += number;
        }
        return sum;
    }

    public static double min(double[] numbers) {
        double min = numbers[0];
        for (double number : numbers) {
            if (number < min) {
                min = number;
            }
        }
        return min;
    }

    public static double max(double[] numbers) {
        double max = numbers[0];
        for (double number : numbers) {
            if (number > max) {
                max = number;
            }
        }
        return max;
    }

    public static double avg(double[] numbers) {
        return Statistics.sum(numbers) / numbers.length;
    }

    public static double[] valueTable() {
        double[] numbers = new double[10];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = ThreadLocalRandom.current().nextDouble(0, 100 + 1);
        }
        return numbers;
    }
}
