package com.dsa.airtribedsa.recursion;

public class Print1ToN {
    public static void main(String[] args) {
//        print1ToN(5, 1);
        print1ToN(5);
    }

    private static void print1ToN(int n, int current) {
        if (current > n) {
            return;
        }
        System.out.println(current);
        print1ToN(n, current + 1);
    }

    private static void print1ToN(int n) {
        //Base condition || Terminate condition
        if (n == 0) {
            return;
        }
        //How do I solve the current state
        //What sub-problem do I want recursion to solve for me.
        print1ToN(n - 1);
        System.out.println(n);
    }
}
