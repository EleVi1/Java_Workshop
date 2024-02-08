package fr.epita.assistants.mycompany;

import java.nio.charset.StandardCharsets;

abstract public class Employee {

    private String lastName;
    private String firstName;

    public Employee(String lastName, String firstName) {
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void sayMyName()
    {
        System.out.println("My name is " + firstName + " " + lastName + ".");
    }

    public String toString()
    {
        StringBuilder s = new StringBuilder();
        s.append(getFirstName()).append(" ").append(getLastName());
        return s.toString();
    }

    abstract void sayMyJob();
}
