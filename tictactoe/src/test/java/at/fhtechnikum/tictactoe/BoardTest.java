package at.fhtechnikum.tictactoe;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoardTest {

    @Test
    void shouldInitializeBoardWithEmptyCells() {
        Board board = new Board();

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                assertEquals('-', board.getCell(row, col));
            }
        }
    }

    @Test
    void shouldClearBoard() {
        Board board = new Board();

        board.clearBoard();

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                assertEquals('-', board.getCell(row, col));
            }
        }
    }
}