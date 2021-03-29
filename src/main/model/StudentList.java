package model;

import java.util.ArrayList;

//Represents the list of Student
public class StudentList {
    private ArrayList<Student> students;

    public StudentList() {
        students = new ArrayList<>();
    }

    // MODIFIES : This
    // EFFECTS  : add a student to a students
    public void addStudent(Student s) {
        students.add(s);
    }

    //getter

    public ArrayList<Student> getStuList() {
        return students;
    }
}



