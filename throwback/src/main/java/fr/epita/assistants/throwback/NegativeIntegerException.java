package fr.epita.assistants;

public class NegativeIntegerException extends IntegerException {
    public NegativeIntegerException(String message) {
        super("IntegerException: NegativeIntegerException: " + message);
    }
}
