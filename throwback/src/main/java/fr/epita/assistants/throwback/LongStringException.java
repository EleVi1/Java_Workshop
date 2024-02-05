package fr.epita.assistants;

public class LongStringException extends StringException {
    public LongStringException(String message, int len) {
        super("StringException: LongStringException: " + message + " (length: " +
                len + ")");
    }
}
