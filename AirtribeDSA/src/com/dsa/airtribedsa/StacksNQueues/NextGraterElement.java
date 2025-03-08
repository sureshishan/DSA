package com.dsa.airtribedsa.StacksNQueues;

import java.util.Arrays;
import java.util.Stack;

public class NextGraterElement {
    public static void main(String[] args) {
        Arrays.stream(nextGreaterElementCircular(new int[]{4, 5, 2, 10, 8})).forEach(System.out::println);
    }

    public static int[] nextGreaterElementCircular(int[] arr) {
        int n = arr.length;
        int res[] = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[i] > arr[stack.peek()]) {
                res[stack.pop()] = arr[i];
            }
            stack.push(i);
        }

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[i] > arr[stack.peek()]) {
                res[stack.pop()] = arr[i];
            }
        }

        while (!stack.isEmpty()) {
            res[stack.pop()] = -1;
        }

        return res;
    }

}
