package com.tictactoe.model;

public class Board {
    private char [][] grid = new char[3][3];

    public Board() {
        // Initialize all elements to space character
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = ' ';
            }
        }
    }

    public boolean mark(int row, int col, char player) {
        if (grid[row][col] == ' ') {
            grid[row][col] = player;
            return true;
        } else {
            return false;
        }
    }

    public char getCell (int row, int col) {
        return grid[row][col];
    }

    public boolean isFull() {
        boolean occ = true;
        while (occ) {
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] != ' ') {
                        occ = true;
                    } else {
                        occ = false;
                    }
                }
            }
        }
        if (!occ) {
            return false;
        } else {
            return true;
        }
    }

    public boolean checkWin(int row, int col, char player) {
        // Check row
        boolean win = true;
        for (int j = 0; j < 3; j++) {
            if (grid[row][j] != player) {
                win = false;
                break;
            }
        }
        if (win) return true;

        // Check column
        win = true;
        for (int i = 0; i < 3; i++) {
            if (grid[i][col] != player) {
                win = false;
                break;
            }
        }
        if (win) return true;

        // Check main diagonal
        if (row == col) {
            win = true;
            for (int i = 0; i < 3; i++) {
                if (grid[i][i] != player) {
                    win = false;
                    break;
                }
            }
            if (win) return true;
        }

        // Check anti-diagonal
        if (row + col == 2) {
            win = true;
            for (int i = 0; i < 3; i++) {
                if (grid[i][2 - i] != player) {
                    win = false;
                    break;
                }
            }
            if (win) return true;
        }

        // No win condition met
        return false;
    }

    public void resetBoard() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = ' ';
            }
        }
    }
}
