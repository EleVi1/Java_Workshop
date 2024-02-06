package fr.epita.assistants.drawing;

public class Triangle extends Sharp {

    int length;
    public Triangle(int length) {
        super(length);
        this.length = length;
    }

    @Override
    public void draw() {
        if (length == 1)
        {
            System.out.println("#");
            return;
        }
        for (int i = 0; i < length; i++)
        {
            for (int j = 0; j <= i; j++)
            {
                if (j == 0 || j == i || i == length - 1)
                {
                    System.out.print("#");
                }
                else {
                    System.out.print(" ");
                }
                System.out.print(" ");
            }
            System.out.print(System.lineSeparator());
        }
    }
}
