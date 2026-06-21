package at.fhtechnikum.tictactoe;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    @Test
    @DisplayName("Positive test: board is initialized with empty cells")
    void shouldInitializeBoardWithEmptyCells() {
        Board board = new Board();

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                assertEquals('-', board.getCell(row, col));
            }
        }
    }

    @Test
    @DisplayName("Positive test: board can be cleared")
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
    @DisplayName("Positive test: board is cleared after markers were placed")
    void shouldClearBoardAfterMarkersWerePlaced() {
        Board board = new Board();

        board.placeMarker(0, 0, 'X');
        board.placeMarker(1, 1, 'O');

        board.clearBoard();

        assertEquals('-', board.getCell(0, 0));
        assertEquals('-', board.getCell(1, 1));
    }

    @Test
    @DisplayName("Positive test: X marker can be placed on an empty cell")
    void shouldPlaceXMarker() {
        Board board = new Board();

        boolean result = board.placeMarker(1, 1, 'X');

        assertTrue(result);
        assertEquals('X', board.getCell(1, 1));
    }

    @Test
    @DisplayName("Positive test: O marker can be placed on an empty cell")
    void shouldPlaceOMarker() {
        Board board = new Board();

        boolean result = board.placeMarker(0, 0, 'O');

        assertTrue(result);
        assertEquals('O', board.getCell(0, 0));
    }

    @Test
    @DisplayName("Positive test: getCell returns marker at valid position")
    void shouldReturnCellValueForValidPosition() {
        Board board = new Board();

        board.placeMarker(2, 2, 'X');

        assertEquals('X', board.getCell(2, 2));
    }

    @Test
    @DisplayName("Negative test: invalid marker is rejected")
    void shouldRejectInvalidMarker() {
        Board board = new Board();

        assertThrows(
                IllegalArgumentException.class,
                () -> board.placeMarker(0, 0, 'A')
        );

        assertEquals('-', board.getCell(0, 0));
    }

    @Test
    @DisplayName("Negative test: occupied cell is rejected")
    void shouldRejectOccupiedCell() {
        Board board = new Board();

        board.placeMarker(1, 1, 'X');

        boolean result = board.placeMarker(1, 1, 'O');

        assertFalse(result);
        assertEquals('X', board.getCell(1, 1));
    }

    @Test
    @DisplayName("Negative test: invalid row is rejected")
    void shouldRejectInvalidRow() {
        Board board = new Board();

        assertThrows(
                IllegalArgumentException.class,
                () -> board.placeMarker(5, 0, 'X')
        );
    }

    @Test
    @DisplayName("Negative test: invalid column is rejected")
    void shouldRejectInvalidColumn() {
        Board board = new Board();

        assertThrows(
                IllegalArgumentException.class,
                () -> board.placeMarker(0, 5, 'O')
        );
    }

    @Test
    @DisplayName("Negative test: negative coordinates are rejected")
    void shouldRejectNegativeCoordinates() {
        Board board = new Board();

        assertThrows(
                IllegalArgumentException.class,
                () -> board.placeMarker(-1, 0, 'X')
        );
    }

    @Test
    @DisplayName("Negative test: getCell rejects row outside the board")
    void shouldRejectGetCellWithInvalidRow() {
        Board board = new Board();

        assertThrows(
                IllegalArgumentException.class,
                () -> board.getCell(5, 0)
        );

        assertThrows(
                IllegalArgumentException.class,
                () -> board.getCell(-1, 0)
        );
    }

    @Test
    @DisplayName("Negative test: getCell rejects column outside the board")
    void shouldRejectGetCellWithInvalidColumn() {
        Board board = new Board();

        assertThrows(
                IllegalArgumentException.class,
                () -> board.getCell(0, 5)
        );

        assertThrows(
                IllegalArgumentException.class,
                () -> board.getCell(0, -1)
        );
    }

    @Test
    @DisplayName("Negative test: board does not change after an invalid move")
    void shouldNotChangeBoardForInvalidMove() {
        Board board = new Board();

        board.placeMarker(0, 0, 'X');

        assertThrows(
                IllegalArgumentException.class,
                () -> board.placeMarker(5, 5, 'O')
        );

        assertEquals('X', board.getCell(0, 0));
    }
}