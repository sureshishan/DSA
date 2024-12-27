package com.dsa.math;

public class LCM {
    public static void main(String[] args) {

        System.out.println("The LCM of given 2 numbers is:" + LCM(4, 6));
        System.out.println("The LCM of given 2 numbers is:" + LCMOptimal(43, 91));

    }

    private static int LCM(int a, int b) {
        int res = Math.max(a, b);
        while (true) {
            if (res % a == 0 && res % b == 0) {
                return res;
            }
            res++;
        }
    }

    private static int LCMOptimal(int a, int b) {
        return (a * b) / GCD(a, b);
    }

    private static int GCD(int a, int b) {
        if (b == 0) {
            return a;
        }
        return GCD(b, a % b);
    }
}
