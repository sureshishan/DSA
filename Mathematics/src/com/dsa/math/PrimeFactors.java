package com.dsa.math;

public class PrimeFactors {
    public static void main(String[] args) {
        primeFactors(12);
        primeFactors2(12);
    }

    private static void primeFactors(int number) {
        for (int i = 2; i * i <= number; i++) {
            if (isPrime(i)) {
                int x = i;

                while (number % x == 0) {
                    System.out.print(" " + i);
                    x = x * i;
                }
            }
        }
    }

    private static void primeFactors2(int number) {
        if (number <= 1) {
            return;
        }

        for (int i = 2; i * i <= number; i++) {
            while (number % i == 0) {
                System.out.print(" " + i);
                number = number / i;
            }
        }

        if (number > 1) {
            System.out.println(" " + number);
        }
    }

    private static boolean isPrime(int number) {

        if (number == 1) {
            return false;
        }

        if (number == 2 || number == 3) {
            return true;
        }

        if (number % 2 == 0 || number % 3 == 0) {
            return false;
        }

        for (int i = 5; i * i <= number; i = i + 6) {
            if (number % i == 0 || number % (i + 2) == 0) {
                return false;
            }
        }

        return true;

    }
}
