package at.fhtechnikum.tictactoe;

public class Main {

    public static void main(String[] args) {

        Game game = new Game();

        game.makeMove(0, 0);
        game.makeMove(1, 0);
        game.makeMove(2, 1);
        game.makeMove(1, 1);
        game.makeMove(0, 2);
        game.makeMove(1, 2);


    }
}