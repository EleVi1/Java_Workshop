package fr.epita.assistants.mycompany;

import java.util.ArrayList;
import java.util.List;

public class Engineer extends Employee implements Assignable{

    public String project;
    public Engineer(String lastName, String firstName) {
        super(lastName, firstName);
        project = null;
    }

    @Override
    void sayMyJob() {
        System.out.println(getFirstName() + " " + getLastName() + " is an engineer.");
    }

    @Override
    public void addProject(String project) {
        this.project = project;
    }

    @Override
    public boolean hasProject(String project) {
        if (this.project == null)
        {
            return false;
        }
        return (this.project.compareTo(project) == 0);
    }

    @Override
    public void listProjects() {
        if (project != null) {
            System.out.println(getFirstName() + " " + getLastName() + "'s current project is " + project + ".");
        }
    }
}
