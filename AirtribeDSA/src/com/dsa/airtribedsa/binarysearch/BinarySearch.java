package com.dsa.airtribedsa.binarysearch;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 7, 11, 13, 17, 19};
        int target = 11;
        System.out.println(binarySearch(arr, target));
        System.out.println(binarySearchRecursive(arr, target, 0, arr.length - 1));
    }

    private static int binarySearchRecursive(int[] arr, int key, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = start + (end - start) / 2;
        if (arr[mid] == key) {
            return mid;
        }

        if (arr[mid] > key) {
            return binarySearchRecursive(arr, key, start, mid - 1);
        }
        return binarySearchRecursive(arr, key, mid + 1, end);
    }

    private static int binarySearch(int[] arr, int key) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == key) {
                return mid;
            }

            if (arr[mid] > key) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
