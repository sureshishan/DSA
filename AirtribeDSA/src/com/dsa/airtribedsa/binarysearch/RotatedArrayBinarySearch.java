package com.dsa.airtribedsa.binarysearch;

public class RotatedArrayBinarySearch {
    public static void main(String[] args) {
        int[] arr = {6, 7, 9, 15, 19, 2, 3};
        System.out.println(rotatedSortedArray(arr, 2));

    }

    private static int rotatedSortedArray(int[] arr, int key) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == key) {
                return mid;//Target found
            }
            //First we need to find the sorted array
            if (arr[start] <= arr[mid]) {//Left side is sorted array
                if (arr[start] <= key && key < arr[mid]) {
                    end = mid - 1; //Search in the left part
                } else {
                    start = mid + 1;
                }
            } else {//Right part is sorted.
                if (arr[mid] < key && key <= arr[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
}
