package fr.epita.assistants;

import fr.epita.assistants.classics.Classics;

import java.util.concurrent.Callable;

public class Main {
    public static void main(String[] args) {
        int n = 5;
        int expected = 120;
        if (Classics.factorial(n) != expected)
            System.err.println("Error factorial("+ n +") " +
                    "-> Actual: " + Classics.factorial(5) + " Expected: " + expected);
        System.out.println(Classics.tribonacci(60));

    }
}
