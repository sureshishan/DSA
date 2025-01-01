package com.dsa.math;

public class FindTheArrayWithNumberOddTimes {
    public static void main(String[] args) {
        int arr[] = {4, 4, 4, 4, 5, 5, 3, 3, 3};zx-
        System.out.println(findTheTheNumberWithOddOccurrences(arr, arr.length));

    }

    private static int findTheTheNumberWithOddOccurrences(int arr[], int number) {
        int res = arr[0];
        for (int i = 1; i < number; i++) {
            res = res ^ arr[i];
        }
        return res;
    }
}
