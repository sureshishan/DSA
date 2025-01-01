package com.dsa.math;

public class CountSetBits {
    private static int table[] = new int[256];

    public static void main(String[] args) {
//        System.out.println("No of 1's in the given numbers is: " + countSetBits(8));
//        System.out.println(countSetBits1(3));
//        System.out.println(countSetBits2(40));
//        System.out.println(countSetBits2(7));
        initialize();
        System.out.println(countSetBitsEfficient(8));
    }

    private static int countSetBits1(int number) {
        int res = 0;
        while (number > 0) {
            /*if(number % 2 == 1){
                res++;
            }*/
            res = res + (number & 1);
            number = number / 2;
        }
        return res;
    }

    private static int countSetBits2(int number) {
        int res = 0;
        while (number > 0) {
            number = (number - 1) & number;
            res++;
        }

        return res;
    }

    //Lookup table solution: O(1)
    private static int countSetBitsEfficient(int number) {
        return table[number & 255] + table[number >> 8 & 255] + table[number >> 16 & 255] + table[number >> 24];

    }

    //Preprocessing
    private static void initialize() {
        table[0] = 0;
        for (int i = 1; i < 256; i++) {
            table[i] = table[i & (i - 1)] + 1;
        }
    }

}
