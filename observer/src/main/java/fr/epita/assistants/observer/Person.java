package fr.epita.assistants.observer;

public class Person  implements Observable.Observer<Swimmer> {

    String person_name;

    public Person(String person_name) {
        this.person_name = person_name;
    }

    @Override
    public void onEvent(Swimmer event) {
        if (event.status.equals(SwimmerStatus.WAVING))
        {
            System.out.println(person_name + ": Waves at " + event.swimmer_name + ".");
        }
    }
}
