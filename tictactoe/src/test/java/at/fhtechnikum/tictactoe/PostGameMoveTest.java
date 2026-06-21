package at.fhtechnikum.tictactoe;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PostGameMoveTest {

    @Test
    void shouldRejectFurtherMovesAfterWin() {
        Game game = new Game();

        game.makeMove(0, 0);
        game.makeMove(1, 0);
        game.makeMove(0, 1);
        game.makeMove(1, 1);
        game.makeMove(0, 2);

        assertTrue(game.hasWinner());
        assertEquals('X', game.getWinner().getMarker());

        assertThrows(IllegalArgumentException.class, () -> game.makeMove(2, 2));
    }
}