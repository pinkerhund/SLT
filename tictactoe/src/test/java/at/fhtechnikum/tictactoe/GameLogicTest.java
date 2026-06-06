package at.fhtechnikum.tictactoe;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameLogicTest {

    @Test
    @DisplayName("Winner test: horizontal win is detected")
    void shouldDetectHorizontalWin() {
        Game game = new Game();

        game.makeMove(0, 0); // X
        game.makeMove(1, 0); // O
        game.makeMove(0, 1); // X
        game.makeMove(1, 1); // O
        game.makeMove(0, 2); // X wins

        assertTrue(game.hasWinner());
        assertEquals('X', game.getWinner().getMarker());
    }

    @Test
    @DisplayName("Winner test: vertical win is detected")
    void shouldDetectVerticalWin() {
        Game game = new Game();

        game.makeMove(0, 0); // X
        game.makeMove(0, 1); // O
        game.makeMove(1, 0); // X
        game.makeMove(1, 1); // O
        game.makeMove(2, 0); // X wins

        assertTrue(game.hasWinner());
        assertEquals('X', game.getWinner().getMarker());
    }

    @Test
    @DisplayName("Winner test: diagonal win is detected")
    void shouldDetectDiagonalWin() {
        Game game = new Game();

        game.makeMove(0, 0); // X
        game.makeMove(0, 1); // O
        game.makeMove(1, 1); // X
        game.makeMove(0, 2); // O
        game.makeMove(2, 2); // X wins

        assertTrue(game.hasWinner());
        assertEquals('X', game.getWinner().getMarker());
    }

    @Test
    @DisplayName("Winner negative test: no winner is reported too early")
    void shouldNotReportWinnerTooEarly() {
        Game game = new Game();

        game.makeMove(0, 0); // X
        game.makeMove(1, 0); // O
        game.makeMove(0, 1); // X

        assertFalse(game.hasWinner());
        assertNull(game.getWinner());
    }

    @Test
    @DisplayName("Draw positive test: draw is detected when board is full and there is no winner")
    void shouldDetectDraw() {
        Game game = new Game();

        game.makeMove(0, 0); // X
        game.makeMove(0, 1); // O
        game.makeMove(0, 2); // X
        game.makeMove(1, 1); // O
        game.makeMove(1, 0); // X
        game.makeMove(1, 2); // O
        game.makeMove(2, 1); // X
        game.makeMove(2, 0); // O
        game.makeMove(2, 2); // X

        assertFalse(game.hasWinner());
        assertTrue(game.isDraw());
    }

    @Test
    @DisplayName("Draw negative test: draw is not detected too early")
    void shouldNotDetectDrawTooEarly() {
        Game game = new Game();

        game.makeMove(0, 0); // X
        game.makeMove(0, 1); // O
        game.makeMove(0, 2); // X

        assertFalse(game.isDraw());
    }

    @Test
    @DisplayName("Player switching test: player switches after a valid move")
    void shouldSwitchPlayerAfterValidMove() {
        Game game = new Game();

        assertEquals('X', game.getCurrentPlayer().getMarker());

        game.makeMove(0, 0);

        assertEquals('O', game.getCurrentPlayer().getMarker());
    }

    @Test
    @DisplayName("Player switching negative test: player does not switch after invalid move")
    void shouldNotSwitchPlayerAfterInvalidMove() {
        Game game = new Game();

        game.makeMove(0, 0);

        assertThrows(
                IllegalArgumentException.class,
                () -> game.makeMove(0, 0)
        );

        assertEquals('O', game.getCurrentPlayer().getMarker());
    }
}
