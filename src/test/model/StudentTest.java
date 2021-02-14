package model;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {
    // delete or rename this class!
    @Test
    public void testStudentConstructor() {
        //create a student
        Student s1 = new Student("David","Presentation", 3,
                "restaurant reservation", "make a reservation");
        //check name
        assertEquals("David",s1.getName());

        //check teamTask
        assertEquals("Presentation", s1.getTeamTask().get(0).getName());
        assertEquals(3,s1.getTeamTask().get(0).getDaysRequired());

        //check personalTask
        ArrayList<PersonalTask> personalTasksExpected
                = new ArrayList<PersonalTask>(Arrays.asList(new PersonalTask("restaurant reservation",
                        "make a reservation")));
;
        assertEquals("restaurant reservation", s1.getPersonalTasks().get(0).getName());
        assertEquals("make a reservation", s1.getPersonalTasks().get(0).getActionToFinishTask());
    }

    @Test
    public void TestAddPersonalTask1() {
        //create a student
        Student s1 = new Student("David","Presentation", 3,
                "restaurant reservation", "make a reservation");
        //add task
        s1.addPersonalTask("task2","do task2");
        //check if added
        assertEquals("task2",s1.getPersonalTasks().get(1).getName());
        assertEquals("do task2",s1.getPersonalTasks().get(1).getActionToFinishTask());
        assertEquals(2,s1.getPersonalTasks().size());

    }
    @Test
    public void TestAddPersonalTaskMoreThan2() {
        //create a student
        Student s1 = new Student("David","Presentation", 3,
                "restaurant reservation", "make a reservation");

        //add task
        s1.addPersonalTask("task2","do task2");
        //add another task
        s1.addPersonalTask("task3","do task3");
        //check if added
        assertEquals("task3",s1.getPersonalTasks().get(2).getName());
        assertEquals("do task3",s1.getPersonalTasks().get(2).getActionToFinishTask());
        assertEquals(3,s1.getPersonalTasks().size());
    }

    @Test
    public void TestRemovePersonalTask1() {
        //create a student
        Student s1 = new Student("David", "Presentation", 3,
                "restaurant reservation",
                "make a reservation");
        //remove the only personal task
        s1.addPersonalTask("11","22");
        System.out.println(s1.getPersonalTasks());
        s1.removePersonalTask("11","22");

        //s1.removePersonalTask("restaurant reservation","make a reservation");
        //check if the task is removed (size = 0)
        //int s3 = s1.getPersonalTasks().size();
        //assertEquals(0, s3);


    }

    @Test
    public void TestEmptyArrayList() {
        ArrayList<Student> emptyList = new ArrayList<>(Arrays.asList(new Student("john", "ss",
                3,"2","33")));
        ArrayList<String> intList = new ArrayList<>(Arrays.asList("1"));
        intList.remove("1");
        System.out.println(intList.size());
        System.out.println(intList);



    }

    @Test
    public void TestRemovePersonalTaskMoreThanOneTask() {
        //create a student
        Student s1 = new Student("David","Presentation", 3,
                "rr", "mr");
        //add task
        s1.addPersonalTask("task2","do task2");
        //add another task
        s1.addPersonalTask("task3","do task3");
        //remove task
        s1.removePersonalTask("task2","do task2");
        //check size = 2
        s1.removePersonalTask("rr","mr");
        assertEquals(1, s1.getPersonalTasks().size());


    }
}