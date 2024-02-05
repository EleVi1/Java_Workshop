package fr.epita.assistants.war;

public class Vehicle extends Combatant {
    public int defense_points;
    public String model_name;
    public Vehicle(String name, int defense) {
        defense_points = defense;
        model_name = name;
    }

    void printState()
    {
        System.out.println("I have " + defense_points + " defense points.");
    }

    @Override
    void attack(Soldier s) {
        s.health_points = 0;
    }

    @Override
    void attack(Vehicle v) {
        v.defense_points = v.defense_points / 2;
    }

    @Override
    void scream() {
        System.out.println("I'm " + model_name + "!");
    }
}
