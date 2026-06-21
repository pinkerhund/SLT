package at.fhtechnikum.tictactoe;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WinnerTest {

    @Test
    @DisplayName("Positive test: horizontal winning combination is detected")
    void shouldDetectHorizontalWin() {
        Game game = new Game();

        game.makeMove(0, 0); // X
        game.makeMove(1, 0); // O
        game.makeMove(0, 1); // X
        game.makeMove(1, 1); // O
        game.makeMove(0, 2); // X wins

        assertTrue(game.hasWinner());
        assertNotNull(game.getWinner());
        assertEquals('X', game.getWinner().getMarker());
    }

    @Test
    @DisplayName("Positive test: vertical winning combination is detected")
    void shouldDetectVerticalWin() {
        Game game = new Game();

        game.makeMove(0, 0); // X
        game.makeMove(0, 1); // O
        game.makeMove(1, 0); // X
        game.makeMove(1, 1); // O
        game.makeMove(2, 0); // X wins

        assertTrue(game.hasWinner());
        assertNotNull(game.getWinner());
        assertEquals('X', game.getWinner().getMarker());
    }

    @Test
    @DisplayName("Positive test: diagonal winning combination from top left to bottom right is detected")
    void shouldDetectDiagonalWinFromTopLeftToBottomRight() {
        Game game = new Game();

        game.makeMove(0, 0); // X
        game.makeMove(0, 1); // O
        game.makeMove(1, 1); // X
        game.makeMove(0, 2); // O
        game.makeMove(2, 2); // X wins

        assertTrue(game.hasWinner());
        assertNotNull(game.getWinner());
        assertEquals('X', game.getWinner().getMarker());
    }

    @Test
    @DisplayName("Positive test: diagonal winning combination from top right to bottom left is detected")
    void shouldDetectDiagonalWinFromTopRightToBottomLeft() {
        Game game = new Game();

        game.makeMove(0, 2); // X
        game.makeMove(0, 0); // O
        game.makeMove(1, 1); // X
        game.makeMove(0, 1); // O
        game.makeMove(2, 0); // X wins

        assertTrue(game.hasWinner());
        assertNotNull(game.getWinner());
        assertEquals('X', game.getWinner().getMarker());
    }

    @Test
    @DisplayName("Negative test: no winner is reported too early")
    void shouldNotReportWinnerTooEarly() {
        Game game = new Game();

        game.makeMove(0, 0); // X
        game.makeMove(1, 0); // O
        game.makeMove(0, 1); // X

        assertFalse(game.hasWinner());
        assertNull(game.getWinner());
    }
}