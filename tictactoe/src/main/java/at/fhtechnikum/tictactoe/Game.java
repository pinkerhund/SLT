package at.fhtechnikum.tictactoe;

public class Game {

    private final Board board;
    private Player currentPlayer;
    private Player winner;

    public Game() {
        this.board = new Board();
        this.currentPlayer = new Player('X');
        this.winner = null;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public Player getWinner() {
        return winner;
    }

    public boolean hasWinner() {
        return winner != null;
    }

    public boolean isDraw() {
        return !hasWinner() && isBoardFull();
    }

    public void makeMove(int row, int col) {
        boolean validMove = board.placeMarker(row, col, currentPlayer.getMarker());

        if (!validMove) {
            throw new IllegalArgumentException("Move is invalid or field is already occupied.");
        }

        board.printBoard();

        if (hasWinningCombination(currentPlayer.getMarker())) {
            winner = currentPlayer;
        }

        switchPlayer();
    }

    private boolean isBoardFull() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (board.getCell(row, col) == '-') {
                    return false;
                }
            }
        }

        return true;
    }

    private void switchPlayer() {
        char nextMarker = currentPlayer.getMarker() == 'X' ? 'O' : 'X';
        currentPlayer = new Player(nextMarker);
    }

    private boolean hasWinningCombination(char marker) {
        return hasHorizontalWin(marker)
                || hasVerticalWin(marker)
                || hasDiagonalWin(marker);
    }

    private boolean hasHorizontalWin(char marker) {
        for (int row = 0; row < 3; row++) {
            if (board.getCell(row, 0) == marker
                    && board.getCell(row, 1) == marker
                    && board.getCell(row, 2) == marker) {
                return true;
            }
        }

        return false;
    }

    private boolean hasVerticalWin(char marker) {
        for (int col = 0; col < 3; col++) {
            if (board.getCell(0, col) == marker
                    && board.getCell(1, col) == marker
                    && board.getCell(2, col) == marker) {
                return true;
            }
        }

        return false;
    }

    private boolean hasDiagonalWin(char marker) {
        boolean diagonalTopLeftToBottomRight =
                board.getCell(0, 0) == marker
                        && board.getCell(1, 1) == marker
                        && board.getCell(2, 2) == marker;

        boolean diagonalTopRightToBottomLeft =
                board.getCell(0, 2) == marker
                        && board.getCell(1, 1) == marker
                        && board.getCell(2, 0) == marker;

        return diagonalTopLeftToBottomRight || diagonalTopRightToBottomLeft;
    }
}