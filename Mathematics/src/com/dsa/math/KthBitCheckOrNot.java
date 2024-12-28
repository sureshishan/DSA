package com.dsa.math;

public class KthBitCheckOrNot {
    public static void main(String[] args) {
        /*positionBitCheck(5, 3);
        isSet(8, 4);
        isSetOneMore(8, 4);*/

        isSetEfficient1(8, 4);
        isSetEfficient2(8, 4);
    }

    private static void positionBitCheck(int number, int position) {
        lastBitCheck(number >> (position - 1));
    }

    private static void lastBitCheck(int number) {
        if ((number & 1) != 0) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    private static void isSet(int number, int k) {
        int x = 1;
        for (int i = 0; i < (k - 1); i++) {
            x = x * 2;
        }

        if ((number & x) != 0) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    private static void isSetOneMore(int n, int k) {
        for (int i = 0; i < (k - 1); i++) {
            n = n / 2;
        }

        if ((n & 1) != 0) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    private static void isSetEfficient1(int n, int k) {
        int x = 1 << (k - 1);

        if ((n & x) != 0) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    private static void isSetEfficient2(int n, int k) {
        if (((n >> (k - 1)) & 1) != 0) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
