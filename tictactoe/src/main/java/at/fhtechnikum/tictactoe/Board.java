package at.fhtechnikum.tictactoe;

public class Board {

    private static final int SIZE = 3;
    private static final char EMPTY_CELL = '-';

    private final char[][] cells;

    public Board() {
        this.cells = new char[SIZE][SIZE];
        clearBoard();
    }

    public void clearBoard() {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                cells[row][col] = EMPTY_CELL;
            }
        }
    }

    public char getCell(int row, int col) {
        validatePosition(row, col);
        return cells[row][col];
    }

    public boolean placeMarker(int row, int col, char marker) {
        if (!isValidMarker(marker)) {
            return false;
        }

        if (!isValidPosition(row, col)) {
            return false;
        }

        if (cells[row][col] != EMPTY_CELL) {
            return false;
        }

        cells[row][col] = marker;
        return true;
    }

    public void printBoard() {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                System.out.print(cells[row][col] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private boolean isValidMarker(char marker) {
        return marker == 'X' || marker == 'O';
    }

    private boolean isValidPosition(int row, int col) {
        return row >= 0 && row < SIZE && col >= 0 && col < SIZE;
    }

    private void validatePosition(int row, int col) {
        if (!isValidPosition(row, col)) {
            throw new IllegalArgumentException("Position is outside the board.");
        }
    }
}