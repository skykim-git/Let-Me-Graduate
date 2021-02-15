package model;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;



public class GameTest {

    @BeforeEach
    void beforeEach() {

        Student s1 =new Student("A",
                "Take Video",
                3 ,
                "Movie Time",
                "Watch Titanic Together",
                1);
        Student s2 = new Student("B",
                "Edit Video",
                3,
                "Not in mood to work",
                "Have the best meal ever together",
                3);
        Student s3 = new Student("C",
                "Write Script",
                2,
                "Have Two Other Midterms",
                "Help Studying",
                2);
        Student s4 = new Student("D",
                "Borrow camera and laptop",
                3,
                "1500 words essay, did not even start",
                "put in library and make coffee",
                5);


        StudentList students = new StudentList();
        students.addStudent(s1);
        students.addStudent(s2);
        students.addStudent(s3);
        students.addStudent(s4);

        Game g1 = new Game("FREN 100 GROUP VIDEO",
                students.getStuList());


    }
    @Test
    public void testProgressToNextDay() {
        Student s1 =new Student("A",
                "Take Video",
                3 ,
                "Movie Time",
                "Watch Titanic Together",
                1);
        Student s2 = new Student("B",
                "Edit Video",
                3,
                "Not in mood to work",
                "Have the best meal ever together",
                3);
        Student s3 = new Student("C",
                "Write Script",
                2,
                "Have Two Other Midterms",
                "Help Studying",
                2);
        Student s4 = new Student("D",
                "Borrow camera and laptop",
                3,
                "1500 words essay, did not even start",
                "put in library and make coffee",
                5);


        StudentList students = new StudentList();
        students.addStudent(s1);
        students.addStudent(s2);
        students.addStudent(s3);
        students.addStudent(s4);

        Game g1 = new Game("FREN 100 GROUP VIDEO",
                students.getStuList());
        // progress to next day
        g1.progressToNextDay();
        // check if the day is the next day
        assertEquals(2,g1.getCurrentDay());
        assertEquals(1,g1.getCurrentTime());



    }

    @Test
    public void testProgressToNextTime() {
        Student s1 =new Student("A",
                "Take Video",
                3 ,
                "Movie Time",
                "Watch Titanic Together",
                1);
        Student s2 = new Student("B",
                "Edit Video",
                3,
                "Not in mood to work",
                "Have the best meal ever together",
                3);
        Student s3 = new Student("C",
                "Write Script",
                2,
                "Have Two Other Midterms",
                "Help Studying",
                2);
        Student s4 = new Student("D",
                "Borrow camera and laptop",
                3,
                "1500 words essay, did not even start",
                "put in library and make coffee",
                5);


        StudentList students = new StudentList();
        students.addStudent(s1);
        students.addStudent(s2);
        students.addStudent(s3);
        students.addStudent(s4);

        Game g1 = new Game("FREN 100 GROUP VIDEO",
                students.getStuList());
        // progress to next time
        assertEquals(1,g1.getCurrentTime());
        g1.progressToNextTime();
        assertEquals(2,g1.getCurrentTime());
    }

    @Test
    public void testProgressToNextTimeToNextDay() {
        Student s1 =new Student("A",
                "Take Video",
                3 ,
                "Movie Time",
                "Watch Titanic Together",
                1);
        Student s2 = new Student("B",
                "Edit Video",
                3,
                "Not in mood to work",
                "Have the best meal ever together",
                3);
        Student s3 = new Student("C",
                "Write Script",
                2,
                "Have Two Other Midterms",
                "Help Studying",
                2);
        Student s4 = new Student("D",
                "Borrow camera and laptop",
                3,
                "1500 words essay, did not even start",
                "put in library and make coffee",
                5);


        StudentList students = new StudentList();
        students.addStudent(s1);
        students.addStudent(s2);
        students.addStudent(s3);
        students.addStudent(s4);

        Game g1 = new Game("FREN 100 GROUP VIDEO",
                students.getStuList());
        //progress to next time (max day times) times
        for (int i = 1 ; i <= g1.getEachDayAllowedTime() ; i++) {
            g1.progressToNextTime();
        }
        assertEquals(2,g1.getCurrentDay());
        assertEquals(1,g1.getCurrentTime());


    }

    @Test
    public void progressToNextTimeNoMoreDays() {
        Student s1 =new Student("A",
                "Take Video",
                3 ,
                "Movie Time",
                "Watch Titanic Together",
                1);
        Student s2 = new Student("B",
                "Edit Video",
                3,
                "Not in mood to work",
                "Have the best meal ever together",
                3);
        Student s3 = new Student("C",
                "Write Script",
                2,
                "Have Two Other Midterms",
                "Help Studying",
                2);
        Student s4 = new Student("D",
                "Borrow camera and laptop",
                3,
                "1500 words essay, did not even start",
                "put in library and make coffee",
                5);


        StudentList students = new StudentList();
        students.addStudent(s1);
        students.addStudent(s2);
        students.addStudent(s3);
        students.addStudent(s4);

        Game g1 = new Game("FREN 100 GROUP VIDEO",
                students.getStuList());

        for (int i = 1 ; i <= (g1.getEachDayAllowedTime())*(g1.getDaysToFinishWork()) ; i++) {
            g1.progressToNextTime();
        }

        assertEquals(1+g1.getDaysToFinishWork(), g1.getCurrentDay());
        assertEquals(1, g1.getCurrentTime());
    }

    @Test
    public void testFinishAPersonalTask() {
        Student s1 =new Student("A",
                "Take Video",
                3 ,
                "Movie Time",
                "Watch Titanic Together",
                1);
        Student s2 = new Student("B",
                "Edit Video",
                3,
                "Not in mood to work",
                "Have the best meal ever together",
                3);
        Student s3 = new Student("C",
                "Write Script",
                2,
                "Have Two Other Midterms",
                "Help Studying",
                2);
        Student s4 = new Student("D",
                "Borrow camera and laptop",
                3,
                "1500 words essay, did not even start",
                "put in library and make coffee",
                5);


        StudentList students = new StudentList();
        students.addStudent(s1);
        students.addStudent(s2);
        students.addStudent(s3);
        students.addStudent(s4);

        Game g1 = new Game("FREN 100 GROUP VIDEO",
                students.getStuList());
        //get rid of a's personal task
        g1.finishAPersonalTask("Watch Titanic Together");
        //size of the listOfPersonalTask and allowed actions should be 3
        assertEquals(3,g1.getListOfPersonalTask().size());
        assertEquals(3,g1.getAvailableActions().size());
        //check if the time is progressed
        assertEquals(2,g1.getCurrentTime());
        //check string in the allowed actions
        boolean isThereRemovedOne = false;
        for (String s : g1.getAvailableActions()) {
            if (s == "Movie Time") {
                isThereRemovedOne = true;
            }
        }
        assertFalse(isThereRemovedOne);
    }
    @Test
    public void testFinishAPersonalTaskProgressToNextDay() {
        Student s1 =new Student("A",
                "Take Video",
                3 ,
                "Movie Time",
                "Watch Titanic Together",
                1);
        Student s2 = new Student("B",
                "Edit Video",
                3,
                "Not in mood to work",
                "Have the best meal ever together",
                3);
        Student s3 = new Student("C",
                "Write Script",
                2,
                "Have Two Other Midterms",
                "Help Studying",
                2);
        Student s4 = new Student("D",
                "Borrow camera and laptop",
                3,
                "1500 words essay, did not even start",
                "put in library and make coffee",
                5);


        StudentList students = new StudentList();
        students.addStudent(s1);
        students.addStudent(s2);
        students.addStudent(s3);
        students.addStudent(s4);

        Game g1 = new Game("FREN 100 GROUP VIDEO",
                students.getStuList());
        //get rid of p.task of student B
        g1.finishAPersonalTask("Have the best meal ever together");
        //check the sizes
        assertEquals(3,g1.getAvailableActions().size());
        assertEquals(3,g1.getListOfPersonalTask().size());
        //check the progression
        assertEquals(2,g1.getCurrentDay());
        assertEquals(1,g1.getCurrentTime());
    }

    // NO TEST FOR showAvailableActions(like getters)

    @Test
    public void testDoTeamTasksOnePersonalTaskDone() {
        Student s1 =new Student("A",
                "Take Video",
                3 ,
                "Movie Time",
                "Watch Titanic Together",
                1);
        Student s2 = new Student("B",
                "Edit Video",
                3,
                "Not in mood to work",
                "Have the best meal ever together",
                3);
        Student s3 = new Student("C",
                "Write Script",
                2,
                "Have Two Other Midterms",
                "Help Studying",
                2);
        Student s4 = new Student("D",
                "Borrow camera and laptop",
                3,
                "1500 words essay, did not even start",
                "put in library and make coffee",
                5);


        StudentList students = new StudentList();
        students.addStudent(s1);
        students.addStudent(s2);
        students.addStudent(s3);
        students.addStudent(s4);

        Game g1 = new Game("FREN 100 GROUP VIDEO",
                students.getStuList());
        //no p.task is done, so no progression
        g1.doTeamTasks();
        //
        g1.finishAPersonalTask("Watch Titanic Together");
        //
        g1.doTeamTasks();
        assertEquals(2,g1.getListOfTeamTask().get(0).getDaysRequired());
        //
        g1.finishAPersonalTask("Have the best meal ever together");
        g1.doTeamTasks();
        assertEquals(0,g1.getListOfTeamTask().get(0).getDaysRequired());
        assertEquals(2,g1.getListOfTeamTask().get(1).getDaysRequired());



    }

    @Test
    public void testIsAllTeamTaskDoneBeforeDueBeforeDue() {
        Student s1 =new Student("A",
                "Take Video",
                0 ,
                "Movie Time",
                "Watch Titanic Together",
                1);
        Student s2 = new Student("B",
                "Edit Video",
                0,
                "Not in mood to work",
                "Have the best meal ever together",
                3);
        Student s3 = new Student("C",
                "Write Script",
                0,
                "Have Two Other Midterms",
                "Help Studying",
                2);
        Student s4 = new Student("D",
                "Borrow camera and laptop",
                0,
                "1500 words essay, did not even start",
                "put in library and make coffee",
                5);


        StudentList students = new StudentList();
        students.addStudent(s1);
        students.addStudent(s2);
        students.addStudent(s3);
        students.addStudent(s4);

        Game g1 = new Game("FREN 100 GROUP VIDEO",
                students.getStuList());
        //check if all team tasks are done
        boolean checkAllRequiredDaysIsZero = true;
        for (Student s : g1.getListOfStudents()) {
            if (s.getTeamTask().get(0).getDaysRequired() !=0) {
                checkAllRequiredDaysIsZero = false;
            }
        }
        assertTrue(checkAllRequiredDaysIsZero);
        assertTrue(g1.isAllTeamTasksDoneBeforeDue());
    }

    @Test
    public void testIsAllTeamTaskDoneBeforeDueAfterDue() {
        Student s1 =new Student("A",
                "Take Video",
                0 ,
                "Movie Time",
                "Watch Titanic Together",
                1);
        Student s2 = new Student("B",
                "Edit Video",
                0,
                "Not in mood to work",
                "Have the best meal ever together",
                3);
        Student s3 = new Student("C",
                "Write Script",
                0,
                "Have Two Other Midterms",
                "Help Studying",
                2);
        Student s4 = new Student("D",
                "Borrow camera and laptop",
                0,
                "1500 words essay, did not even start",
                "put in library and make coffee",
                5);

        StudentList students = new StudentList();
        students.addStudent(s1);
        students.addStudent(s2);
        students.addStudent(s3);
        students.addStudent(s4);

        Game g1 = new Game("FREN 100 GROUP VIDEO",
                students.getStuList());
        //progress days to finish Work
        for (int i = 1; i <= g1.getDaysToFinishWork(); i++) {
            g1.progressToNextDay();
        }
        assertFalse(g1.isAllTeamTasksDoneBeforeDue());
    }

    // NO TEST FOR FINISHGAME
}
