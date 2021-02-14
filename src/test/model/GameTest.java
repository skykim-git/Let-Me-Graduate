package model;


import jdk.nashorn.internal.objects.NativeEvalError;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Array;
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


        Game g1 = new Game("FREN 100 GROUP VIDEO",
                new ArrayList<Student>(Arrays.asList(s1, s2, s3, s4)));


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


        Game g1 = new Game("FREN 100 GROUP VIDEO",
                new ArrayList<Student>(Arrays.asList(s1, s2, s3, s4)));
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


        Game g1 = new Game("FREN 100 GROUP VIDEO",
                new ArrayList<Student>(Arrays.asList(s1, s2, s3, s4)));
        // progress to next time
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


        Game g1 = new Game("FREN 100 GROUP VIDEO",
                new ArrayList<Student>(Arrays.asList(s1, s2, s3, s4)));
        //progress to next time (max day times) times
        for (int i = 1 ; i <= g1.getEachDayAllowedTime() ; i++) {
            g1.progressToNextTime();
        }
        assertEquals(2,g1.getCurrentDay());
        assertEquals(1,g1.getCurrentTime());


    }

    @Test
    public void progressToNextTimeNomoreDays() {
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


        Game g1 = new Game("FREN 100 GROUP VIDEO",
                new ArrayList<Student>(Arrays.asList(s1, s2, s3, s4)));

        for (int i = 1 ; i <= (g1.getEachDayAllowedTime())*(g1.getDaysToFinishWork()) ; i++) {
            g1.progressToNextTime();
        }

        assertEquals(1+g1.getDaysToFinishWork(), g1.getCurrentDay());
        assertEquals(1, g1.getCurrentTime());
    }

    @Test
    public void testFinishAPersonalTask() {


    }
}
