package com.dsa.airtribedsa.recursion.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {
    public static void main(String[] args) {
        List<List<String>> solutions = solveNQueens(4);

        for (List<String> solution : solutions) {
            for (String row : solution) {
                System.out.println(row);
            }
            System.out.println();
        }

    }

    private static List<List<String>> solveNQueens(int n) {

        List<List<String>> results = new ArrayList<>();
        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        nQueens(0, board, results);
        return results;
    }

    private static void nQueens(int currentRow, char[][] board, List<List<String>> results) {

        int n = board.length;

        if (currentRow == n) {
            results.add(construct(board));
            return;
        }

        //Current Row
        for (int col = 0; col < n; col++) {
            if (isSafe(currentRow, col, board)) {
                board[currentRow][col] = 'Q'; //Place Queen
                nQueens(currentRow + 1, board, results);//Recursive for nest row
                board[currentRow][col] = '.';// Backtrack
            }
        }
    }


    private static boolean isSafe(int row, int column, char[][] board) {
        int n = board.length;

        //Check column
        for (int i = 0; i < row; i++) {
            if (board[i][column] == 'Q') {
                return false;
            }
        }

        // Check upper-left diagonal
        for (int i = row - 1, j = column - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // Check upper-right diagonal
        for (int i = row - 1, j = column + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;

    }

    private static List<String> construct(char[][] board) {
        List<String> result = new ArrayList<>();
        for (char[] row : board) {
            result.add(new String(row));
        }
        return result;
    }

}
