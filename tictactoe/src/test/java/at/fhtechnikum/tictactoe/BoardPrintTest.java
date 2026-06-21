package at.fhtechnikum.tictactoe;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

class BoardPrintTest {

    @Test
    void printBoardShouldContainMarkersAndEmptyCells() {
        Board board = new Board();
        board.placeMarker(0, 0, 'X');
        board.placeMarker(1, 1, 'O');

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream original = System.out;
        System.setOut(new PrintStream(out));
        try {
            board.printBoard();
        } finally {
            System.setOut(original);
        }

        String printed = out.toString();
        assertTrue(printed.contains("X"), "Expected printed board to contain 'X'. Output:\n" + printed);
        assertTrue(printed.contains("O"), "Expected printed board to contain 'O'. Output:\n" + printed);
        assertTrue(printed.contains("-"), "Expected printed board to contain '-' for empty cells. Output:\n" + printed);
    }
}