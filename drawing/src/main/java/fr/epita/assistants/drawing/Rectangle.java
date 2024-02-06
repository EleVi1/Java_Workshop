package fr.epita.assistants.drawing;

import org.apache.commons.lang3.StringUtils;

public class Rectangle extends Sharp {

    private int width;
    public Rectangle(int width, int length) {
        super(length);
        this.width = width;
    }

    @Override
    public void draw()
    {
        System.out.println(StringUtils.repeat('#', width));
        for (int i = 1; i < length - 1; i++)
        {
            System.out.println('#' + StringUtils.repeat(' ', width - 2) + '#');
        }
        System.out.println(StringUtils.repeat('#', width));
    }
}
