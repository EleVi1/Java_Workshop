package fr.epita.assistants.drawing;

public class Circle extends Entity {

    private int rad;

    public Circle(int radius)
    {
        super();
        rad = radius;
    }


    @Override
    public void draw() {
        for (int y = -rad; y <= rad; y++)
        {
            for (int x = -rad; x <= rad; x++)
            {
                int sqDist = Math.abs(rad*rad - (x*x + y*y));
                if (sqDist < rad) {
                    System.out.print("#");
                }
                else {
                    System.out.print(" ");
                }
                if (x < rad) {
                    System.out.print(" ");
                }
            }
            if (y < rad)
            {
                System.out.print(System.lineSeparator());
            }
        }
    }
}
