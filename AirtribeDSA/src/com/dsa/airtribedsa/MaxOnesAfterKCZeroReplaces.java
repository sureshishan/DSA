package com.dsa.airtribedsa;

public class MaxOnesAfterKCZeroReplaces {
    public static void main(String[] args) {
        System.out.println(maxOnesAfterKZeroReplaces(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2));
    }

    private static int maxOnesAfterKZeroReplaces(int numbers[], int k) {
        int start = 0;
        int end = 0;
        int maxSize = 0;
        int zeroCount = 0;
        int n = numbers.length;
        while (end < n) {
            if (numbers[end] == 0) {
                zeroCount++;
            }
            while (zeroCount > k) {
                if (numbers[start] == 0) {
                    zeroCount--;
                }
                start++;
            }
            maxSize = Math.max(maxSize, end - start + 1);
            end++;
        }
        return maxSize;
    }
}
