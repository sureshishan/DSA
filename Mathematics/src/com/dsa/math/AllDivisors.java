package com.dsa.math;

public class AllDivisors {
    public static void main(String[] args) {
//        divisors(25);
        AllDivisors(15);
    }

    private static void divisors(int number) {
        for (int i = 1; i * i <= number; i++) {
            if (number % i == 0) {
                System.out.print(" " + i);
                if (i != number / i) {
                    System.out.print(" " + number / i);
                }
            }
        }
    }

    private static void AllDivisors(int number) {
        int i;
        for (i = 1; i * i < number; i++) {
            if (number % i == 0) {
                System.out.print(" " + i);
            }
        }
        for (; i >= 1; i--) {
            if (number % i == 0) {
                System.out.print(" " + number / i);
            }
        }

    }
}
