package at.fhtechnikum.tictactoe;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameLogicTest {

    @Test
    @DisplayName("Positive test: new game starts with player X")
    void shouldStartWithPlayerX() {
        Game game = new Game();

        assertEquals('X', game.getCurrentPlayer().getMarker());
        assertFalse(game.hasWinner());
        assertNull(game.getWinner());
        assertFalse(game.isDraw());
    }

    @Test
    @DisplayName("Positive test: player switches after a valid move")
    void shouldSwitchPlayerAfterValidMove() {
        Game game = new Game();

        game.makeMove(0, 0);

        assertEquals('O', game.getCurrentPlayer().getMarker());
    }

    @Test
    @DisplayName("Positive test: player switches back to X after two valid moves")
    void shouldSwitchBackToPlayerXAfterTwoValidMoves() {
        Game game = new Game();

        game.makeMove(0, 0); // X
        game.makeMove(1, 1); // O

        assertEquals('X', game.getCurrentPlayer().getMarker());
    }

    @Test
    @DisplayName("Negative test: occupied field is rejected")
    void shouldRejectMoveOnOccupiedField() {
        Game game = new Game();

        game.makeMove(0, 0);

        assertThrows(
                IllegalArgumentException.class,
                () -> game.makeMove(0, 0)
        );
    }

    @Test
    @DisplayName("Negative test: player does not switch after invalid move")
    void shouldNotSwitchPlayerAfterInvalidMove() {
        Game game = new Game();

        game.makeMove(0, 0);

        assertThrows(
                IllegalArgumentException.class,
                () -> game.makeMove(0, 0)
        );

        assertEquals('O', game.getCurrentPlayer().getMarker());
    }

    @Test
    @DisplayName("Negative test: move outside the board is rejected")
    void shouldRejectMoveOutsideBoard() {
        Game game = new Game();

        assertThrows(
                IllegalArgumentException.class,
                () -> game.makeMove(3, 0)
        );

        assertEquals('X', game.getCurrentPlayer().getMarker());
        assertFalse(game.hasWinner());
        assertFalse(game.isDraw());
    }
}