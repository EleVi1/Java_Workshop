package fr.epita.assistants.mycompany;

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

    abstract void sayMyJob();
}
