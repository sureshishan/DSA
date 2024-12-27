package com.dsa.math;

public class PrimeNumberCheck {
    public static void main(String[] args) {

        System.out.println("The is given number is Prime:" + isPrime(91));
        System.out.println("The is given number is Prime:" + isPrimeOptimal1(43));
        System.out.println("The is given number is Prime:" + isPrimeOptimal(43));

    }

    private static boolean isPrime(int number) {
        if (number == 1) {
            return false;
        }

        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static boolean isPrimeOptimal1(int number) {
        if (number == 1) {
            return false;
        }

        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static boolean isPrimeOptimal(int number) {
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
