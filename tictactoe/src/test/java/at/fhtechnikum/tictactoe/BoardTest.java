package at.fhtechnikum.tictactoe;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    void shouldPlaceXMarker() {
        Board board = new Board();

        board.placeMarker(1, 1, 'X');

        assertEquals('X', board.getCell(1, 1));
    }

    @Test
    void shouldPlaceOMarker() {
        Board board = new Board();

        board.placeMarker(0, 0, 'O');

        assertEquals('O', board.getCell(0, 0));
    }

    @Test
    void shouldRejectInvalidMarker() {
        Board board = new Board();

        boolean result = board.placeMarker(0, 0, 'A');

        assertFalse(result);
        assertEquals('-', board.getCell(0, 0));
    }
}