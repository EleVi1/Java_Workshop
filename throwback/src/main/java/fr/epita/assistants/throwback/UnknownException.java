package fr.epita.assistants;

public class UnknownException extends Exception {
    public UnknownException(String message) {
        super("UnknownException: " + message);
    }
}
