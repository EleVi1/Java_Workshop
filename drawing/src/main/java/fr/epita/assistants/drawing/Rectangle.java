package fr.epita.assistants.drawing;


public class Rectangle extends Sharp {

    private int width;
    public Rectangle(int width, int length) {
        super(length);
        this.width = width;
    }

    @Override
    public void draw()
    {
        if (length == width && length == 1)
        {
            System.out.println("#");
            return;
        }
        for (int i = 0; i < width; i++) {
            System.out.print("# ");
        }
        System.out.print(System.lineSeparator());
        int space = 2 * width;
        for (int i = 1; i < length - 1; i++)
        {
            System.out.print("# ");
            for (int k = 0; k < space - 4; k++)
            {
                System.out.print(" ");
            }
            System.out.print("# ");
            System.out.print(System.lineSeparator());
        }
        for (int i = 0; i < width; i++) {
            System.out.print("# ");
        }
        System.out.print(System.lineSeparator());
    }
}
