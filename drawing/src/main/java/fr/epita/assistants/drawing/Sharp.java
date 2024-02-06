package fr.epita.assistants.drawing;

abstract class Sharp extends Entity {

    protected int length;
    public Sharp(int length)
    {
        super(length);
        this.length = length;
    }
}
