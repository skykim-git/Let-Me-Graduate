package model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StudentListTest {

    @Test
    public void testAddStudent1() {
        StudentList stuList = new StudentList();
        Student newStudent1 = new Student(
                "A",
                "B",
                3,
                "Eat",
                "Eat together",
                3);

        stuList.addStudent(newStudent1);

        assertEquals(1, stuList.getStuList().size());
    }

    @Test
    public void testAddStudent2() {
        StudentList stuList = new StudentList();
        Student newStudent1 = new Student(
                "A",
                "B",
                3,
                "Eat",
                "Eat together",
                3);
        Student newStudent2 = new Student(
                "AA",
                "BB",
                3,
                "Eat2",
                "Eat together2",
                3);

        stuList.addStudent(newStudent1);
        stuList.addStudent(newStudent2);


        assertEquals(2, stuList.getStuList().size());
    }
}
