package at.fhtechnikum.tictactoe;


public class Game {

    private final Board board;
    private Player currentPlayer;

    public Game() {
        this.board = new Board();
        this.currentPlayer = new Player('X');
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void makeMove(int row, int col) {
        boolean validMove = board.placeMarker(row, col, currentPlayer.getMarker());

        if (!validMove) {
            throw new IllegalArgumentException("Move is invalid or field is already occupied.");
        }

        switchPlayer();
    }

    private void switchPlayer() {
        char nextMarker = currentPlayer.getMarker() == 'X' ? 'O' : 'X';
        currentPlayer = new Player(nextMarker);
    }
}

