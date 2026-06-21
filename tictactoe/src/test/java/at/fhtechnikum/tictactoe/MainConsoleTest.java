package at.fhtechnikum.tictactoe;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

class MainConsoleTest {

    @Test
    void shouldHandleInvalidInputWithoutCrashingAndShowPlayAgainPrompt() throws Exception {
        String simulatedInput =
                "invalid\n" +
                        "0\n0\n" +
                        "1\n0\n" +
                        "0\n1\n" +
                        "1\n1\n" +
                        "0\n2\n" +
                        "n\n";

        InputStream originalIn = System.in;
        PrintStream originalOut = System.out;

        ByteArrayInputStream testIn = new ByteArrayInputStream(simulatedInput.getBytes());
        ByteArrayOutputStream testOutBuffer = new ByteArrayOutputStream();
        PrintStream testOut = new PrintStream(testOutBuffer);

        try {
            System.setIn(testIn);
            System.setOut(testOut);

            Main.main(new String[0]);

            String output = testOutBuffer.toString();

            assertTrue(output.toLowerCase().contains("invalid input"),
                    "Expected output to contain an invalid input message, but was:\n" + output);

            assertTrue(output.toLowerCase().contains("play again"),
                    "Expected output to contain play-again prompt, but was:\n" + output);

            assertTrue(output.toLowerCase().contains("wins"),
                    "Expected output to contain a winner message, but was:\n" + output);

        } finally {
            System.setIn(originalIn);
            System.setOut(originalOut);
        }
    }
}