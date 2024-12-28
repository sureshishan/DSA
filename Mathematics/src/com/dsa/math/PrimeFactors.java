package com.dsa.math;

public class PrimeFactors {
    public static void main(String[] args) {
//        primeFactors(12);
//        primeFactors2(12);
        primeFactorsMoreEfficient(12);
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

    private static void primeFactorsMoreEfficient(int number) {
        if (number <= 1) return;
        while (number % 2 == 0) {
            System.out.print(" " + 2);
            number = number / 2;
        }
        while (number % 3 == 0) {
            System.out.println(" " + 3);
            number = number / 3;
        }

        for (int i = 5; i * i <= number; i = i + 6) {
            while (number % i == 0) {
                System.out.print(" " + i);
                number = number / i;
            }

            while ((number % (i + 2) == 0)) {
                System.out.print(" " + i + 2);
                number = number / (i + 2);
            }
        }
        if (number > 3) {
            System.out.print(" " + number);
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
