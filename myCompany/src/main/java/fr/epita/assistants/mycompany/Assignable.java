package fr.epita.assistants.mycompany;

import java.util.List;

public interface Assignable {

    List<String> projects = null;
    void addProject(String project);
    boolean hasProject(String project);
    void listProjects();
}
