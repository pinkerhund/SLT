package at.fhtechnikum.tictactoe;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    @DisplayName("Positive test: player can be created with valid markers")
    void shouldCreatePlayerWithValidMarkers() {
        Player x = new Player('X');
        Player o = new Player('O');

        assertEquals('X', x.getMarker());
        assertEquals('O', o.getMarker());
    }

    @Test
    @DisplayName("Negative test: player creation rejects invalid marker")
    void shouldThrowForInvalidMarker() {
        assertThrows(IllegalArgumentException.class, () -> new Player('A'));
    }
}