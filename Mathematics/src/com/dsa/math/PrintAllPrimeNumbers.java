package com.dsa.math;

import java.util.Arrays;

public class PrintAllPrimeNumbers {
    public static void main(String[] args) {
//        printAllPrimeNumbers(25);
        printAllPrimeNumbersEfficient(25);
    }

    private static void printAllPrimeNumbers(int number) {
        for (int i = 2; i <= number; i++) {
            if (isPrime(i)) {
                System.out.print(" " + i);
            }
        }
    }

    private static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        if (number == 2 || number == 3) {
            return true;
        }

        if (number % 2 == 0 || number % 3 == 0) {
            return false;
        }

        for (int i = 5; i <= Math.sqrt(number); i = i + 6) {
            if (number % i == 0 || number % (i + 2) == 0) {
                return false;
            }
        }

        return true;
    }


    //Sieve's algorithm
    private static void printAllPrimeNumbersEfficient(int number) {
        if (number <= 1) {
            return;
        }

        boolean[] isPrime = new boolean[number + 1];

        Arrays.fill(isPrime, true);

        for (int i = 2; i <= number; i++)
            if (isPrime[i]) {
                for (int j = 2 * i; j <= number; j = j + i)
                    isPrime[j] = false;
            }

        for (int i = 2; i <= number; i++)
            if (isPrime[i]) System.out.print(i + " ");
    }

    private static void printAllPrimeNumbersEfficient2(int number) {
        if (number <= 1) {
            return;
        }
        boolean[] isPrime = new boolean[number + 1];
        Arrays.fill(isPrime, true);
        for (int i = 2; i <= number; i++)
            if (isPrime[i]) {
                System.out.print(i + " ");
                for (int j = i * i; j <= number; j = j + i)
                    isPrime[j] = false;
            }
    }
}
