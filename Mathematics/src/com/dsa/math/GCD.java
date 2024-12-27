package com.dsa.math;

public class GCD {
    public static void main(String[] args) {
        System.out.println("GCD of the given number :" + gcd(10, 15));
        System.out.println("GCD of the given number :" + euclidean(10, 15));
        System.out.println("GCD of the given number :" + gcdRec(43, 91));
    }

    //Iterative solution
    private static int gcd(int a, int b) {
        int res = Math.min(a, b);

        while (res > 0) {
            if (a % res == 0 && b % res == 0) {
                break;
            }
            res--;
        }
        return res;
    }

    //Repetitive subtraction
    private static int euclidean(int a, int b) {
        while (a != b) {
            if (a > b) {
                a = a - b;
            } else {
                b = b - a;
            }
        }
        return a;
    }

    //Repetitive Modulo Division
    private static int gcdRec(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcdRec(b, a % b);
    }
}
