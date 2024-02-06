package fr.epita.assistants.drawing;

public class Triangle extends Sharp {

    int length;
    public Triangle(int length) {
        super(length);
        this.length = length;
    }

    @Override
    public void draw() {
        for (int i = 0; i < length; i++)
        {
            for (int j = i; j >= 0; j--)
            {
                if (j == i || j == 0 || i == length - 1)
                {
                    System.out.print("#");
                }
                else
                {
                    System.out.print(" ");
                }
            }
            System.out.print(System.lineSeparator());
        }
    }
}
