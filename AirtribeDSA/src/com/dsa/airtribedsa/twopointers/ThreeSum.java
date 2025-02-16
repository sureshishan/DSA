package com.dsa.airtribedsa.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        int[] numbers = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> results = threeSum(numbers);
        for (List<Integer> result : results) {
            System.out.println(result);
        }
    }

    private static List<List<Integer>> threeSum(int[] numbers) {

        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(numbers); //Sort the arrays to use 2 pointer technique

        //-4, -1, -1, 0, 1, 2
        for (int i = 0; i < numbers.length - 2; i++) {
            if (i > 0 && numbers[i] == numbers[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = numbers.length - 1;
            while (left < right) {
                int sum = numbers[i] + numbers[left] + numbers[right];
                if (sum == 0) {
                    results.add(Arrays.asList(numbers[i], numbers[left], numbers[right]));

                    //Move the left and right pointers and skip the duplicates
                    while (left < right && numbers[left] == numbers[left + 1]) left++;
                    while (left < right && numbers[right] == numbers[right - 1]) right--;
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++; //Increase the sum by moving the left pointer
                } else {
                    right--; //Decrease the sum by moving the right pointer
                }
            }
        }
        return results;

    }
}
