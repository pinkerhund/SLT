package at.fhtechnikum.tictactoe;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DrawTest {

    @Test
    @DisplayName("Positive test: draw is detected when board is full and no player has won")
    void shouldDetectDrawWhenBoardIsFullAndNoPlayerHasWon() {
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
        assertNull(game.getWinner());
        assertTrue(game.isDraw());
    }

    @Test
    @DisplayName("Negative test: draw is not detected while empty fields remain")
    void shouldNotDetectDrawWhileEmptyFieldsRemain() {
        Game game = new Game();

        game.makeMove(0, 0); // X
        game.makeMove(0, 1); // O
        game.makeMove(0, 2); // X

        assertFalse(game.isDraw());
    }

    @Test
    @DisplayName("Negative test: draw is not reported if there is a winner")
    void shouldNotReportDrawIfThereIsWinner() {
        Game game = new Game();

        game.makeMove(0, 0); // X
        game.makeMove(1, 0); // O
        game.makeMove(0, 1); // X
        game.makeMove(1, 1); // O
        game.makeMove(0, 2); // X wins

        assertTrue(game.hasWinner());
        assertEquals('X', game.getWinner().getMarker());
        assertFalse(game.isDraw());
    }
}