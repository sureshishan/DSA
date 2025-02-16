package com.dsa.airtribedsa.recursion;

public class FibonacciSeries {
    public static void main(String[] args) {

        int n = 10;

        for (int i = 0; i < n; i++) {
            System.out.println(fibonacci(i));
        }

//        System.out.println(fibonacci(5));

    }

    private static int fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
