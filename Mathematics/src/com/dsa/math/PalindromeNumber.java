package com.dsa.math;

import java.util.Scanner;

public class PalindromeNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the value of the number:");
        int number = scanner.nextInt();
        System.out.println(isPalindrome(number));
    }

    private static boolean isPalindrome(int number) {
        int temp = number;
        int rev = 0;
        while(temp != 0){
            int rem = temp % 10;
            rev = rev * 10 + rem;
            temp = temp / 10;
        }

        return number == rev;

    }
}
