package com.dsa.airtribedsa.recursion;

public class ClimbStairs {
    public static void main(String[] args) {
        System.out.println(climbStairs(5));
    }

    private static int climbStairs(int n) {
        if (n <= 3) {
            return n;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }
}
