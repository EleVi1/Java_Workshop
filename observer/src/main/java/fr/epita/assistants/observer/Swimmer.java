package fr.epita.assistants.observer;

import javax.xml.transform.OutputKeys;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Swimmer  implements Observable<Swimmer> {

    Set<Observer<Swimmer>> observers;
    String swimmer_name;
    SwimmerStatus status = SwimmerStatus.OK;

    public Swimmer(String swimmer_name) {
        this.swimmer_name = swimmer_name;
        observers = new HashSet<>();
        System.out.println(swimmer_name + " goes into the sea.");
    }

    public String getName() {
        return swimmer_name;
    }

    public SwimmerStatus getStatus() {
        return status;
    }

    public void setStatus(SwimmerStatus status) {
        this.status = status;
        if (this.status == SwimmerStatus.DROWNING)
        {
            System.out.println(swimmer_name + ": I'm drowning, help!!");
        }
        if (this.status == SwimmerStatus.WAVING)
        {
            System.out.println(swimmer_name + ": Waves towards the shore.");
        }
        fire(this);
    }

    @Override
    public Set<Observer<Swimmer>> getObservers() {
        return observers;
    }

    @Override
    public void register(Observer<Swimmer>... observers) {
        this.observers.addAll(List.of(observers));
    }

    @Override
    public void unregister(Observer<Swimmer> observer) {
        observers.remove(observer);
    }

    @Override
    public void fire(Swimmer event) {
        for (Observer<Swimmer> obs: observers)
        {
            obs.onEvent(event);
        }
    }
}
