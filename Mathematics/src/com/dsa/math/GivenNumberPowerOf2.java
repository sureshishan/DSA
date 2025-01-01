package com.dsa.math;

public class GivenNumberPowerOf2 {
    public static void main(String[] args) {
//        System.out.println("The given number is power of 2: " + isNumberPowerOf2(4));
        System.out.println("The given number is power of 2: " + isNumberPowerOf2Efficient(4));
    }

    //Naive solution
    private static boolean isNumberPowerOf2(int number) {
        if (number == 0) {
            return false;
        }
        while (number != 1) {
            if (number % 2 != 0) {
                return false;
            }
            number = number / 2;
        }
        return true;
    }

    //Brain Cunningham algorithm: efficient solution
    private static boolean isNumberPowerOf2Efficient(int number) {
        if (number == 0) {
            return false;
        }
        return ((number & (number - 1)) == 0);

        //single line statement
//        return (number && ((number & (number - 1)) == 0));


    }
}
