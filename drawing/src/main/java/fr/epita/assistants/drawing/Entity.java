package fr.epita.assistants.drawing;

public abstract class Entity implements IDrawable {

    private long id;
    static private long SEQUENCE;

    public Entity(long id) {
        this.id = id;
        id = SEQUENCE;
        SEQUENCE++;
    }

    public long getid()
    {
        return id;
    }

    @Override
    public void draw()
    {}
}
