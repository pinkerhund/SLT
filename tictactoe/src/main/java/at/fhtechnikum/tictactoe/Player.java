package at.fhtechnikum.tictactoe;

public class Player {

    private final char marker;

    public Player(char marker) {
        if (marker != 'X' && marker != 'O') {
            throw new IllegalArgumentException("Player marker must be X or O.");
        }

        this.marker = marker;
    }

    public char getMarker() {
        return marker;
    }
}