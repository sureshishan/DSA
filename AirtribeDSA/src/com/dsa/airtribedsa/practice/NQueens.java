package com.dsa.airtribedsa.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {
    public static void main(String[] args) {

        List<List<String>> solutions = solveQueens(4);

        for (List<String> solution : solutions) {
            for (String row : solution) {
                System.out.println(row);
            }
            System.out.println();
        }

    }

    private static List<List<String>> solveQueens(int n) {
        char[][] board = new char[n][n];
        List<List<String>> results = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        nQueens(0, board, results);
        return results;
    }

    private static void nQueens(int currentRow, char[][] board, List<List<String>> results) {
        int n = board.length;

        //Base condition
        if (currentRow == n) {
            results.add(construct(board));
            return;
        }

        //current Row
        for (int column = 0; column < n; column++) {
            if (isSafe(currentRow, column, board)) {
                board[currentRow][column] = 'Q';
                nQueens(currentRow + 1, board, results);
                board[currentRow][column] = '.';
            }
        }

    }

    private static boolean isSafe(int row, int column, char[][] board) {

        int n = board.length;

        //Check Column
        for (int i = 0; i < row; i++) {
            if (board[i][column] == 'Q') {
                return false;
            }
        }

        //Upper-left Diagonal
        for (int i = row - 1, j = column - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        //Upper-right Diagonal
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
