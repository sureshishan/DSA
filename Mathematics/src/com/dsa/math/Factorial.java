package com.dsa.math;

import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        System.out.println("Factorial of the given number is:" + factorial(new Scanner(System.in).nextInt()));
        System.out.println("Factorial of the given number is:" + fact(new Scanner(System.in).nextInt()));
    }


    //Iterative
    private static int factorial(int number) {
        int i = 2;
        int fact = 1;
        while (i <= number) {
            fact = fact * i;
            i++;
        }
        return fact;
    }

    //Recursive
    private static int fact(int number) {
        if (number == 0) {
            return 1;
        }
        return number * fact(number - 1);
    }
}
