package com.dsa.math;

public class ComputePower {
    public static void main(String[] args) {
//        System.out.println(power(2, 3));
        System.out.println(powerEfficient(2, 4));
    }

    private static int power(int x, int n) {
        int res = 1;
        for (int i = 0; i < n; i++) {
            res = res * x;
        }
        return res;
    }


    private static int powerEfficient(int x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n % 2 == 0) {
            return power(x, n / 2) * power(x, n / 2);
        } else {
            return power(x, n - 1) * x;
        }
    }
}
