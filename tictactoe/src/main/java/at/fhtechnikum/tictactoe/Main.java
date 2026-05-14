package at.fhtechnikum.tictactoe;

public class Main {

    public static void main(String[] args) {

        Board board = new Board();

        board.placeMarker(1, 1, 'X');
        board.placeMarker(0, 0, 'O');

        board.printBoard();
    }
}