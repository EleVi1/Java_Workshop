package fr.epita.assistants.mycompany;

import java.util.ArrayList;
import java.util.List;

public class Manager extends Employee implements Assignable {

    private List<String> projects = new ArrayList<>();
    public Manager(String lastName, String firstName) {
        super(lastName, firstName);
    }

    @Override
    void sayMyJob() {
        System.out.println(getFirstName() + " " + getLastName() + " is a manager.");
    }

    @Override
    public void addProject(String project) {
        if (!projects.contains(project))
        {
            projects.add(project);
        }
    }

    @Override
    public boolean hasProject(String project) {
        return projects.contains(project);
    }

    @Override
    public void listProjects() {
        if (projects != null && !projects.isEmpty()) {
            System.out.println(getFirstName() + " " + getLastName() + "'s current projects are:");
            for (String p: projects)
            {
                System.out.println("- " + p);
            }
        }
    }
}
