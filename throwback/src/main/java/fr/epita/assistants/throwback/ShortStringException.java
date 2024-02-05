package fr.epita.assistants;

public class ShortStringException extends StringException {
    public ShortStringException(String message, int len) {
        super("StringException: ShortStringException: " + message + " (length: " +
                len + ")");
    }
}
