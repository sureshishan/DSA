package com.dsa.math;
public class CountDigits {
    public static void main(String[] args) {
        System.out.println("No.Of Digits:" + countDigits(789));
    }
    private static int countDigits(int number) {
        int result = 0;
        while (number > 0) {
            number = number / 10;
            result++;
        }
        return result;
    }
}

// Time complexity O(d) , where d id the number of digits
