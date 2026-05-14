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

    @Test
    void shouldRejectOccupiedCell() {
        Board board = new Board();

        board.placeMarker(1, 1, 'X');

        boolean result = board.placeMarker(1, 1, 'O');

        assertFalse(result);
        assertEquals('X', board.getCell(1, 1));
    }

    @Test
    void shouldRejectInvalidRow() {
        Board board = new Board();

        boolean result = board.placeMarker(5, 0, 'X');

        assertFalse(result);
    }

    @Test
    void shouldRejectInvalidColumn() {
        Board board = new Board();

        boolean result = board.placeMarker(0, 5, 'O');

        assertFalse(result);
    }

    @Test
    void shouldRejectNegativeCoordinates() {
        Board board = new Board();

        boolean result = board.placeMarker(-1, 0, 'X');

        assertFalse(result);
    }

    @Test
    void shouldNotChangeBoardForInvalidMove() {
        Board board = new Board();

        board.placeMarker(0, 0, 'X');

        board.placeMarker(5, 5, 'O');

        assertEquals('X', board.getCell(0, 0));
    }
}