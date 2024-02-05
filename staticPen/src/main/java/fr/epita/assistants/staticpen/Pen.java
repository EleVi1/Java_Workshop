package fr.epita.assistants.staticpen;

public class Pen {
    static int blue_counter = 0;
    static int red_counter = 0;
    private Color colour;

    public enum Color {
        RED,
        BLUE
    }

    public Pen(final Color color) {
        if (color == Color.RED)
        {
            red_counter++;
        }
        if (color == Color.BLUE)
        {
            blue_counter++;
        }
        colour = color;
    }

    public static int getRedPenCounter() {
        return red_counter;
    }

    public static int getPenCounter() {
        return blue_counter + red_counter;
    }

    public static int getBluePenCounter() {
        return blue_counter;
    }

    public void changeColor(final Color color) {
        if (colour != color)
        {
            colour = color;
            if (color == Color.RED)
            {
                blue_counter--;
                red_counter++;
            }
            else {
                blue_counter++;
                red_counter--;
            }
        }
    }

    public static void resetCounts() {
        red_counter = 0;
        blue_counter = 0;
    }

    public void print() {
        System.out.println("I'm a " + colour + " pen.");
    }
}
