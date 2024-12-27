package com.dsa.math;

import java.util.Scanner;

public class TrailingZerosInFactorial {
    public static void main(String[] args) {

//        System.out.println("No.of trailing zeros in factorial of number is:" + countTrailingZeros(new Scanner(System.in).nextInt()));
        System.out.println("No.of trailing zeros in factorial of number is:" + countZeros(new Scanner(System.in).nextInt()));

    }

    //Normal case
    private static int countTrailingZeros(int number) {
        int fact = 1;
        for (int i = 2; i <= number; i++) {
            fact = fact * i;
        }

        int zerosCount = 0;
        while (fact % 10 == 0) {
            zerosCount++;
            fact = fact / 10;
        }
        return zerosCount;
    }

    //Best case solution Time complexity : log n
    private static int countZeros(int number) {
        int res = 0;
        for (int i = 5; i <= number; i = i * 5) {
            res = res + number / i;
        }
        return res;
    }

}
