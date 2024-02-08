package fr.epita.assistants.exceptions;

import java.util.Arrays;
import java.util.List;

public class Student {
    String name;
    int age;
    String major;
    public Student(String name, int age, String major) throws InvalidAgeException, InvalidNameException, InvalidMajorException {
        String copy = major.toUpperCase();
        if (name.matches("^.*[0-9].*$"))
        {
            throw new InvalidNameException(name);
        }
        if (age < 0 || age >= 130)
        {
            throw new InvalidAgeException(age);
        }
        String[] majors = {"IMAGE", "SRS", "GISTRE", "SCIA", "MTI", "TCOM", "SIGL", "GITM",
        "ICE", "SANTE", "SSIE", "IF", "STARTUP", "Q"};
        if (!Arrays.stream(majors).toList().contains(copy))
        {
            throw new InvalidMajorException(major);
        }
        this.name = name;
        this.age = age;
        this.major = copy;
    }
    @Override
    public String toString()
    {
        StringBuilder s = new StringBuilder();
        s.append("Name: ").append(name).append(", Age: ").append(age).append(", Major: ").append(major);
        return s.toString();
    }
}
