package fr.epita.assistants.mycompany;

public class Engineer extends Employee implements Assignable{

    private String project;
    public Engineer(String lastName, String firstName) {
        super(lastName, firstName);
        project = "";
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
        return this.project.equals(project);
    }

    @Override
    public void listProjects() {
        if (project != null) {
            System.out.println(getFirstName() + " " + getLastName() + "'s current project is " + project + ".");
        }
    }
}
