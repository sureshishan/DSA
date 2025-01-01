package com.dsa.airtribedsa;

import java.util.Arrays;

public class FindTheSumOfPairIsTarget {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int target = 10;
        Arrays.stream(findThePairSumIsTarget(arr, target)).forEach(value -> {
            System.out.println("Index: " + value + ", " + "Value: " + arr[value]);
        });
    }

    private static int[] findThePairSumIsTarget(int[] numbers, int target) {
        int left = 0;
        int sum = 0;
        int right = numbers.length - 1;
        while (left < right) {
            sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{left, right};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        throw new UnsupportedOperationException("Pair not found");
    }
}
