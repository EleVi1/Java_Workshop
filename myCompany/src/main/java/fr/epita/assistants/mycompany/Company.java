package fr.epita.assistants.mycompany;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Company {
    String name;
    List<Employee> employees;
    HashMap<Employee, Manager> employeeManagement;

    public Company(String name) {
        this.name = name;
        employees = new ArrayList<>();
        employeeManagement = new HashMap<>();
    }

    public int size()
    {
        return employees.size();
    }
    public void hire(Employee p)
    {
        employees.add(p);
    }

    public void fire(Employee p)
    {
        employees.remove(p);
    }

    public void printEmployees()
    {
        System.out.println("The company " + name + " employs:");
        for (Employee e: employees)
        {
            System.out.println("- " + e.getFirstName() + " " + e.getLastName());
        }
    }
    public boolean addEmployeeManagement(Employee e, Manager m)
    {
        boolean err = false;
        if (!employees.contains(e)) {
            err = true;
            System.out.println(e.getFirstName() + " " + e.getLastName() + " is not employed by " + name + ".");
        }
        if (!employees.contains(m)) {
            System.out.println(m.getFirstName() + " " + m.getLastName() + " is not employed by " + name + ".");
        }
        if (err) {
            return false;
        }
        if (!employeeManagement.containsKey(e))
        {
            System.out.println(e.getFirstName() + " " + e.getLastName() + " now has a manager.");
            employeeManagement.put(e, m);
        }
        if (!employeeManagement.get(e).equals(m))
        {
            System.out.println(e.getFirstName() + " " + e.getLastName() + " has a new manager.");
            employeeManagement.replace(e, m);
        }
        return true;
    }

    public void printManager(Employee e)
    {
        if (!employeeManagement.containsKey(e))
        {
            System.out.println(e.getFirstName() + " " + e.getLastName() + " is managed by nobody.");
        }
        else
        {
            System.out.println(employeeManagement.get(e).getFirstName() + " " + employeeManagement.get(e).getLastName()
                    + " manages " + e.getFirstName() + " " + e.getLastName() + ".");
        }
    }

    void printEmployeesProject()
    {
        for (Employee e: employees)
        {
            if (e instanceof Manager || e instanceof Engineer)
            {
                ((Assignable) e).listProjects();
            }
        }
    }
}
