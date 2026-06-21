package at.fhtechnikum.tictactoe;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameEndTest {

    @Test
    @DisplayName("Positive test: winner is reported after winning move")
    void shouldReportWinnerAfterWinningMove() {
        Game game = new Game();

        game.makeMove(0, 0); // X
        game.makeMove(1, 0); // O
        game.makeMove(0, 1); // X
        game.makeMove(1, 1); // O
        game.makeMove(0, 2); // X wins

        assertTrue(game.hasWinner());
        assertNotNull(game.getWinner());
        assertEquals('X', game.getWinner().getMarker());
        assertFalse(game.isDraw());
    }

    @Test
    @DisplayName("Negative test: further moves are rejected after a win")
    void shouldRejectFurtherMovesAfterWin() {
        Game game = new Game();

        game.makeMove(0, 0); // X
        game.makeMove(1, 0); // O
        game.makeMove(0, 1); // X
        game.makeMove(1, 1); // O
        game.makeMove(0, 2); // X wins

        assertTrue(game.hasWinner());
        assertEquals('X', game.getWinner().getMarker());

        assertThrows(
                IllegalArgumentException.class,
                () -> game.makeMove(2, 2)
        );
    }

    @Test
    @DisplayName("Negative test: further moves are rejected after a draw")
    void shouldRejectFurtherMovesAfterDraw() {
        Game game = new Game();

        game.makeMove(0, 0); // X
        game.makeMove(0, 1); // O
        game.makeMove(0, 2); // X
        game.makeMove(1, 1); // O
        game.makeMove(1, 0); // X
        game.makeMove(1, 2); // O
        game.makeMove(2, 1); // X
        game.makeMove(2, 0); // O
        game.makeMove(2, 2); // X, draw

        assertFalse(game.hasWinner());
        assertNull(game.getWinner());
        assertTrue(game.isDraw());

        assertThrows(
                IllegalArgumentException.class,
                () -> game.makeMove(2, 2)
        );
    }
}