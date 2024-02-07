package fr.epita.assistants.grades;

import fr.epita.assistants.grades.model.*;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class GradeHandler {
    private final List<Activity> activities;
    private final List<Student> students;

    public GradeHandler() {
        this.activities = new ArrayList<>();
        this.students = new ArrayList<>();
    }

    /**
     * @param activity The {@link Activity} to be added
     * @return {@code true} (as specified by {@link List#add})
     */
    public boolean addActivity(Activity activity) {
       return activities.add(activity);
    }

    /**
     * @param student The {@link Student} to be added
     * @return {@code true} (as specified by {@link List#add})
     */
    public boolean addStudent(Student student) {
        return students.add(student);
    }

    /**
     * @param name The name of the desired {@link Student}
     * @return The desired student
     * @throws EntryNotFoundException No known {@link Student} with the given name
     */
    public Student getStudent(String name) throws EntryNotFoundException {
        Optional<Student> std = students.stream().filter(s ->s.name().equals(name)).findFirst();
        if (std.isEmpty()) {
            throw new EntryNotFoundException(Student.class, name);
        }
        return std.get();
    }

    /**
     * @param grade The {@link Grade} to be added to the {@link Student}
     * @param name  The name of the desired {@link Student}
     * @return {@code true} (as specified by {@link List#add})
     * @throws EntryNotFoundException No known {@link Student} with the given name
     */
    public boolean addGradeToStudent(Grade grade, String name) throws EntryNotFoundException {
        return getStudent(name).grades().add(grade);
    }

    /**
     * @param name The name of the desired {@link Student} to remove
     * @return The removed {@link Student}
     * @throws EntryNotFoundException No known {@link Student} with the given name
     */
    public Student removeStudent(String name) throws EntryNotFoundException {
        Student s = getStudent(name);
        students.remove(s);
        return s;
    }

    /**
     * @param name     The name of the desired {@link Student}
     * @param function A {@link Function} returning an updated {@link Student} from the given one
     * @throws EntryNotFoundException No known {@link Student} with the given name
     */
    public void updateStudent(String name, Function<Student, Student> function) throws EntryNotFoundException {
        function.apply(getStudent(name));
    }

    /**
     * @param name    The name of the {@link Student} from which to get grades
     * @param subject The {@link Subject} from which we want the student's average
     * @return The student's average grade in the specified subject (0 if no grades are available)
     * @throws EntryNotFoundException No known {@link Student} with the given name
     */
    public double getStudentAverageInSubject(String name, Subject subject) throws EntryNotFoundException {
        Student s = getStudent(name);
        Stream<Grade> grade = s.grades().stream().filter(g -> g.activity().subject().equals(subject));
        Stream<Grade> coeff = s.grades().stream().filter(g -> g.activity().subject().equals(subject));
        double sum_grade = grade.mapToDouble(g -> g.grade() * g.activity().weight()).sum();
        double sum_weight = coeff.mapToDouble(g -> g.activity().weight()).sum();
        return sum_grade/sum_weight;
    }
}
