package com.dsa.airtribedsa.recursion;

public class PrintAllPermutations {
    public static void main(String[] args) {

        generatePermutations("ABC", "");

    }

    private static void generatePermutations(String input, String current) {

        if (input.isEmpty()) {
            System.out.println(current);
            return;
        }

        for (int i = 0; i < input.length(); i++) {
            // Choose one character to fix in the current position
            char chosen = input.charAt(i);

            // Remaining string after removing the chosen character
            String remaining = input.substring(0, i) + input.substring(i + 1);

            // Recurse with the remaining string and updated current string
            generatePermutations(remaining, current + chosen);
        }

    }
}


// Problem: Print all Permutations
//