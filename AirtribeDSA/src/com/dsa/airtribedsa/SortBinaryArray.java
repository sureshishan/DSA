package com.dsa.airtribedsa;

import java.util.Arrays;

public class SortBinaryArray {
    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 1, 0, 1, 1, 0, 0};
        sortBinaryArray(arr);
    }

    private static void sortBinaryArray(int[] arr) {
        int start = 0, end = arr.length - 1;
        while (start < end) {
            if (arr[start] == 1 && arr[end] == 0) {
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                end--;
            } else if (arr[start] == 0) {
                start++;
            } else if (arr[end] == 1) {
                end--;
            }
        }

        Arrays.stream(arr).forEach(System.out::println);
    }
}
