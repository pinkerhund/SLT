package at.fhtechnikum.tictactoe;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class RestartTest {

    @Test
    void newGameShouldStartWithEmptyBoardAndXAsCurrentPlayer() throws Exception {

        Game game = new Game();
        game.makeMove(0, 0); // X
        game.makeMove(0, 1); // O

        Game restarted = new Game();

        assertEquals('X', restarted.getCurrentPlayer().getMarker());

        assertFalse(restarted.hasWinner());
        assertFalse(restarted.isDraw());

        Field boardField = Game.class.getDeclaredField("board");
        boardField.setAccessible(true);
        Board restartedBoard = (Board) boardField.get(restarted);

        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                assertEquals('-', restartedBoard.getCell(r, c),
                        String.format("Expected cell (%d,%d) to be empty in restarted game", r, c));
            }
        }
    }
}