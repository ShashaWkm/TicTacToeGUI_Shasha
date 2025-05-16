package com.tictactoe.controller;

import com.tictactoe.model.Board;
import com.tictactoe.model.Player;

public class Game {
    private Board board;
    //private Board cell;
    private Player player1;
    private Player player2;
    
    private Player currentPlayer;
    private boolean isGameOver;

    public Game(Player player1, Player player2) {
        board = new Board();
        this.currentPlayer = player1;
        isGameOver = false;
    }

    public void switchPlayer() {
        if (currentPlayer == player1) {
            currentPlayer = player2;
        } else {
            currentPlayer = player1;
        }
    }

    public boolean makeMove(int row, int col) {
        if (!isGameOver && board.getCell(row, col) == ' ') {
            board.mark(row, col, currentPlayer.getSymbol());

            if (board.checkWin(row, col, currentPlayer.getSymbol())) {
                isGameOver = true;
            } else if (board.isFull()){
                isGameOver = true;
            };

            if (!isGameOver) {
                switchPlayer();
            }

            return true;
        } else {
            return false;
        }
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public boolean isGameOver() {
        return isGameOver;
    }

    public void resetGame() {
        board.resetBoard();
        currentPlayer = player1;
        isGameOver = false;
    }

    public Board getBoard() {
        return board;
    }

}
