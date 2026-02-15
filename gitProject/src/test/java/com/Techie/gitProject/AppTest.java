package com.Techie.gitProject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for {@link App}.
 */
public class AppTest {

    @Test
    public void mainPrintsExpectedLines() {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        try {
            App.main(new String[0]);
            String output = baos.toString();
            assertTrue(output.contains("Changes done by Developer2"), "Expected developer change line missing");
            assertTrue(output.contains("Hello World changed!"), "Expected hello world line missing");
        } finally {
            System.setOut(originalOut);
        }
    }

    @Test
    public void fibonacciSequenceReturnsEmptyForZero() {
        List<Integer> seq = App.fibonacciSequence(0);
        assertEquals(0, seq.size());
    }

    @Test
    public void fibonacciSequenceReturnsFirstTen() {
        List<Integer> seq = App.fibonacciSequence(10);
        assertEquals(10, seq.size());
        assertEquals(List.of(0, 1, 1, 2, 3, 5, 8, 13, 21, 34), seq);
    }

    @Test
    public void fibonacciSequenceThrowsForNegative() {
        assertThrows(IllegalArgumentException.class, () -> App.fibonacciSequence(-1));
    }
}