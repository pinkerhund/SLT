package at.fhtechnikum.tictactoe;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class GameTest {

    @Test
    @DisplayName("Positive test: player switches after a valid move")
    void shouldSwitchPlayerAfterValidMove() {
        Game game = new Game();

        game.makeMove(0, 0);

        assertEquals('O', game.getCurrentPlayer().getMarker());
    }

    @Test
    @DisplayName("Negative test: throws exception when field is already occupied")
    void shouldThrowExceptionWhenFieldIsAlreadyOccupied() {
        Game game = new Game();

        game.makeMove(0, 0);

        assertThrows(
                IllegalArgumentException.class,
                () -> game.makeMove(0, 0)
        );

        assertEquals('O', game.getCurrentPlayer().getMarker());
    }
}