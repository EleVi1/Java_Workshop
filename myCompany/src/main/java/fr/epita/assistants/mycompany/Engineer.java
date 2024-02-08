package fr.epita.assistants.mycompany;

import java.util.ArrayList;
import java.util.List;

public class Engineer extends Employee implements Assignable{

    public List<String> project;
    public Engineer(String lastName, String firstName) {
        super(lastName, firstName);
        project = new ArrayList<>();
    }

    @Override
    void sayMyJob() {
        System.out.println(getFirstName() + " " + getLastName() + " is an engineer.");
    }

    @Override
    public void addProject(String project) {
        this.project.add(0, project);
    }

    @Override
    public boolean hasProject(String project) {
        return this.project.get(0).equals(project);
    }

    @Override
    public void listProjects() {
        if (project != null) {
            System.out.println(getFirstName() + " " + getLastName() + "'s current project is " + project + ".");
        }
    }
}
