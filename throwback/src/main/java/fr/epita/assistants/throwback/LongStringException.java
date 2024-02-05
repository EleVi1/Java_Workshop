package fr.epita.assistants.throwback;

public class LongStringException extends StringException {
    public LongStringException(String message, int len) {
        super("LongStringException: " + message + " (length: " +
                len + ")");
    }
}
