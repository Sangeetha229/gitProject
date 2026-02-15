
package com.Techie.gitProject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for {@link App}.
 * 
 * Approach:
 * - Redirect {@code System.out} to a {@link ByteArrayOutputStream} to capture console output.
 * - Invoke the method under test.
 * - Assert the captured output matches the expected text.
 * - Restore the original {@code System.out} in a finally block to avoid side effects.
 */
public class AppTest {

    /**
     * Verifies that {@code App.main} prints the expected informational lines.
     *
     * Setup: redirect {@code System.out} to capture output.
     * Action: call {@code App.main(new String[0])}.
     * Assertion: the captured output contains the two expected lines printed by main.
     * Cleanup: restore the original {@code System.out}.
     */
    @Test
    public void mainPrintsExpectedLines() {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        try {
            App.main(new String[0]);
            String output = baos.toString();
            // Ensure both expected messages printed by main are present
            assertTrue(output.contains("Changes done by Developer2"), "Expected developer change line missing");
            assertTrue(output.contains("Hello World changed!"), "Expected hello world line missing");
        } finally {
            // Restore standard output to avoid interfering with other tests
            System.setOut(originalOut);
        }
    }

    /**
     * Verifies that {@code App.fibonacci(0)} prints only the header line with no numbers.
     *
     * Setup: redirect {@code System.out} to capture output.
     * Action: call {@code new App().fibonacci(0)}.
     * Assertion: the captured output equals the header followed by a platform newline.
     * Cleanup: restore the original {@code System.out}.
     */
    @Test
    public void fibonacciPrintsEmptyForZero() {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        try {
            new App().fibonacci(0);
            String expected = "Fibonacci Series: " + System.lineSeparator();
            assertEquals(expected, baos.toString());
        } finally {
            System.setOut(originalOut);
        }
    }

    /**
     * Verifies that {@code App.fibonacci(10)} prints the first ten Fibonacci numbers after the header.
     *
     * Setup: redirect {@code System.out} to capture output.
     * Action: call {@code new App().fibonacci(10)}.
     * Assertion: the captured output matches the header plus the expected sequence and a newline.
     * Cleanup: restore the original {@code System.out}.
     */
    @Test
    public void fibonacciPrintsFirstTen() {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        try {
            new App().fibonacci(10);
            String expected = "Fibonacci Series: 0 1 1 2 3 5 8 13 21 34 " + System.lineSeparator();
            assertEquals(expected, baos.toString());
        } finally {
            System.setOut(originalOut);
        }
    }
}
