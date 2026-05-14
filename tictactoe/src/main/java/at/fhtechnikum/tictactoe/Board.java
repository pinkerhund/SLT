package at.fhtechnikum.tictactoe;

public class Board {

    private final char[][] cells;

    public Board() {
        cells = new char[3][3];
        clearBoard();
    }

    public void clearBoard() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                cells[row][col] = '-';
            }
        }
    }

    public char getCell(int row, int col) {
        return cells[row][col];
    }

    public void printBoard() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                System.out.print(cells[row][col] + " ");
            }
            System.out.println();
        }
    }
}