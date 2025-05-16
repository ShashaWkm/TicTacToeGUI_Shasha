package com.tictactoe.view;

import com.tictactoe.controller.Game;
import com.tictactoe.model.Board;
import com.tictactoe.model.Player;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TicTacToeGUI extends Application {
    private Game game;
    private Board board;
    private Button[][] buttons = new Button[3][3];
    private Label statusLabel;
    private Button newGameButton;

    @Override
    public void start(Stage stage) {
        Player player1 = new Player("Xavier", 'X');
        Player player2 = new Player("Michelle", 'O');
        this.game = new Game(player1, player2);

        Label title = new Label("Tic-Tac-Toe");
        BorderPane border = new BorderPane();

        border.setTop(title);

        statusLabel = new Label("Current Player: " + game.getCurrentPlayer().getName());

        GridPane grid = new GridPane();
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                Button btn = new Button(" ");
                btn.setPrefSize(100, 100);
                btn.setStyle("-fx-font-size: 24px;");
                int r = row, c = col;

                btn.setOnAction(e -> {
                    if (game.makeMove(r, c)) {
                        btn.setText(String.valueOf(game.getBoard().getCell(r, c)));
                        btn.setDisable(true);
                        updateStatus();
                        if (game.isGameOver()) disableBoard();
                    }
                });

                buttons[row][col] = btn;
                grid.add(btn, col, row);
            }
        }


        newGameButton = new Button("New Game");
        newGameButton.setOnAction(e -> {
            game.resetGame();
            resetGUI();
        });

        VBox layout = new VBox(10, statusLabel, grid, newGameButton,border);
        layout.setAlignment(Pos.CENTER);

        stage.setScene(new Scene(layout));
        stage.setTitle("Tic Tac Toe");
        stage.show();

    }

    private void updateStatus() {
        statusLabel.setText(game.getCurrentPlayer().getName());
    }

    private void disableBoard() {
        for (Button[] row : buttons)
            for (Button b : row)
                b.setDisable(true);
    }

    private void enableBoard() {
        for (Button[] row : buttons)
            for (Button b : row)
                b.setDisable(false);
    }

    private void resetGUI() {
        for (Button[] row : buttons)
            for (Button b : row) {
                b.setText(" ");
                b.setDisable(false);
            }
        updateStatus();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
