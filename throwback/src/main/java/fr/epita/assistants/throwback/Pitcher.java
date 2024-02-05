package fr.epita.assistants.throwback;

public class Pitcher extends Exception {

    public static boolean isDigit(String msg, int n)
    {
        int minus = 0;
        int i = 0;
        if (msg.charAt(0) == '-')
        {
            i++;
            if (n == 1)
            {
                return false;
            }
        }
        while (i < n)
        {
            if (Character.isDigit(msg.charAt(i)))
            {
                i++;
            }
            else
            {
                return false;
            }
        }
        return true;
    }
    public static void throwException(String message) throws
            LongStringException, ShortStringException,
            PositiveIntegerException, NegativeIntegerException,
            UnknownException {
        int n = message.length();
        if (n == 0)
        {
            throw new UnknownException(message);
        }
        if (isDigit(message, n))
        {
            if (message.charAt(0) == '-')
            {
                throw new NegativeIntegerException(message);
            }
            else {
                throw new PositiveIntegerException(message);
            }
        }
        else if (isString(message, n)) {
            if (n >= 100)
            {
                throw new LongStringException(message, n);
            }
            else {
                throw new ShortStringException(message, n);
            }
        }
        else {
            throw new UnknownException(message);
        }
    }

    private static boolean isString(String msg, int n) {
        int i = 0;
        while (i < n)
        {
            if (Character.isLetter(msg.charAt(i)) || msg.charAt(i) == ' ' ||
            msg.charAt(i) == ',' || msg.charAt(i) == '`' || msg.charAt(i) == '.' ||
            msg.charAt(i) == '\'')
            {
                i++;
            }
            else {
                return false;
            }
        }
        return true;
    }

}
