package com.Techie.gitProject;

import java.util.ArrayList;
import java.util.List;

/**
 * Application helper with Fibonacci utilities and a simple CLI main.
 */
public class App {

    /**
     * Return the first {@code n} Fibonacci numbers as a list.
     * <p>
     * Contract: n >= 0. If n == 0 the returned list is empty. If n &lt; 0 an
     * IllegalArgumentException is thrown.
     *
     * @param n number of Fibonacci numbers to generate
     * @return list containing the first n Fibonacci numbers
     */
    public static List<Integer> fibonacciSequence(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n must be >= 0");
        }
        List<Integer> result = new ArrayList<>(Math.max(0, n));
        int a = 0, b = 1;
        for (int i = 0; i < n; i++) {
            result.add(a);
            int next = a + b;
            a = b;
            b = next;
        }
        return result;
    }

    /**
     * Print the Fibonacci sequence header and the first {@code n} values to System.out.
     * This is a thin wrapper around {@link #fibonacciSequence(int)} kept for CLI compatibility.
     *
     * @param n number of Fibonacci numbers to print
     */
    public static void fibonacci(int n) {
        System.out.print("Fibonacci Series: ");
        List<Integer> seq = fibonacciSequence(n);
        for (Integer v : seq) {
            System.out.print(v + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("Changes done by Developer2");
        System.out.println("Hello World changed!");
        // preserve previous behavior (prints a single value by default)
        fibonacci(1);
    }
}