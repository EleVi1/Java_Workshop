package fr.epita.assistants;

import fr.epita.assistants.throwback.*;

/**
 * A very simple test
 */
public class Main {
    public static void main(String[] args) throws NegativeIntegerException, ShortStringException, PositiveIntegerException, UnknownException, LongStringException {
        /*
          Replace this String to try other exceptions.
          Hint: this one should trigger an UnknownException.
         */
        String exception = "-";

        try {
            Pitcher.throwException(exception);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        exception = "I'm dishonest, and a dishonest man you can always trust to be dishonest... Honestly, it's the honest ones you want to watch out for, because you can never predict when they're going to do something incredibly...stupid.";

        try {
            Pitcher.throwException(exception);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        exception = "-42";

        try {
            Pitcher.throwException(exception);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        exception = "abcd";

        try {
            Pitcher.throwException(exception);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
