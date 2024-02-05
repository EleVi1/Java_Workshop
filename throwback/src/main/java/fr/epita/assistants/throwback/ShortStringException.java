package fr.epita.assistants.throwback;

public class ShortStringException extends StringException {
    public ShortStringException(String message, int len) {
        super("ShortStringException: " + message + " (length: " +
                len + ")");
    }
}
