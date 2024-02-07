package fr.epita.assistants.observer;

public class Lifeguard implements Observable.Observer<Swimmer> {

    String lifeguard_name;
    public Lifeguard(String name) {
        this.lifeguard_name = name;
        System.out.println(name + " begins to keep an eye on the swimmers.");
    }

    @Override
    public void onEvent(Swimmer event) {
        if (event.status.equals(SwimmerStatus.DROWNING))
        {
            System.out.println(lifeguard_name + ": I will save you " + event.swimmer_name + "!");
        }
        if (event.status.equals(SwimmerStatus.TOO_FAR))
        {
            System.out.println(lifeguard_name + ": " + event.swimmer_name + "! You are too far, come back!");
        }
    }
}
