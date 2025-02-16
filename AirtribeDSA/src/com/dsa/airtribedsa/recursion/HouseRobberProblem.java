package com.dsa.airtribedsa.recursion;

public class HouseRobberProblem {
    public static void main(String[] args) {
        int[] houses = {20, 10, 30, 100, 99};
        System.out.println(rob(houses, 0));
    }

    private static int rob(int[] houses, int currentIndex) {
        if (currentIndex >= houses.length) {
            return 0;
        }
        int robCurrent = houses[currentIndex] + rob(houses, currentIndex + 2);

        int skipCurrent = rob(houses, currentIndex + 1);

        return Math.max(robCurrent, skipCurrent);
    }
}
