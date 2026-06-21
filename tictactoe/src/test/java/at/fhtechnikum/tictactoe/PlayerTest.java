package at.fhtechnikum.tictactoe;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void shouldCreatePlayerWithValidMarkers() {
        Player x = new Player('X');
        Player o = new Player('O');
        assertEquals('X', x.getMarker());
        assertEquals('O', o.getMarker());
    }

    @Test
    void shouldThrowForInvalidMarker() {
        assertThrows(IllegalArgumentException.class, () -> new Player('A'));
    }
}