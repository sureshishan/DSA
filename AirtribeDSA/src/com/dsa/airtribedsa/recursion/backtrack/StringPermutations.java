package com.dsa.airtribedsa.recursion.backtrack;

public class StringPermutations {
    public static void main(String[] args) {
        String str = "ABC";
        System.out.println("Permutations of the string\"" + str + "\": ");
        generatePermutations(str.toCharArray(), 0);
    }

    private static void generatePermutations(char[] chars, int index) {
        if (index == chars.length - 1) {
            System.out.println(new String(chars));
            return;
        }
        for (int i = index; i < chars.length; i++) {
            swap(chars, index, i);
            generatePermutations(chars, index + 1);
            swap(chars, index, i);
        }
    }

    private static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
