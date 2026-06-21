package at.fhtechnikum.tictactoe;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class BoardGetCellTest {

    @Test
    void getCellShouldThrowForInvalidPosition() {
        Board board = new Board();

        assertThrows(IllegalArgumentException.class, () -> board.getCell(5, 0));
        assertThrows(IllegalArgumentException.class, () -> board.getCell(0, 5));

        assertThrows(IllegalArgumentException.class, () -> board.getCell(-1, 0));
        assertThrows(IllegalArgumentException.class, () -> board.getCell(0, -1));
    }
}