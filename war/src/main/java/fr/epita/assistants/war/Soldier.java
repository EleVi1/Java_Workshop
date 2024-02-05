package fr.epita.assistants.war;

public class Soldier extends Combatant {
    public int health_points;
    public int damage_points;
    public String scream;

    public Soldier() {
        health_points = 15;
        damage_points = 3;
        scream = "No pity for losers!";
    }

    void printState()
    {
        System.out.println("I have " + health_points + " health points.");
    }
    @Override
    void attack(Soldier s) {
        s.health_points -= damage_points;
    }

    @Override
    void attack(Vehicle v) {
        System.out.println("I can't fight this.");
    }

    @Override
    void scream() {
        System.out.println(scream);
    }

    public void kill () {
        health_points = 0;
    }
}
