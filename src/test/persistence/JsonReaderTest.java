package persistence;

import model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class JsonReaderTest {

    Student s1;
    Student s2;
    Student s3;
    Student s4;

    StudentList students;

    @BeforeEach
    void runBeforeEach() {
        StudentList stuList = new StudentList();

        s1 =new Student("A",
                "Take Video",
                0 ,
                "Movie Time",
                "Watch Titanic Together",
                1);
        s2 = new Student("B",
                "Edit Video",
                0,
                "Not in mood to work",
                "Have the best meal ever together",
                3);
        s3 = new Student("C",
                "Write Script",
                0,
                "Have Two Other Midterms",
                "Help Studying",
                2);
        s4 = new Student("D",
                "Borrow camera and laptop",
                0,
                "1500 words essay, did not even start",
                "put in library and make coffee",
                5);

        students = new StudentList();

        students.addStudent(s1);
        students.addStudent(s2);
        students.addStudent(s3);
        students.addStudent(s4);
    }

    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            Game game = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    // tests redundant for empty case and reader case.
    //create file
//    @Test
//    void testReaderGeneralGame() {
//        try {
//            Game game = new Game("G1", students);
//            JsonWriter writer = new JsonWriter("./data/testReaderGeneralGame.json");
//            writer.open();
//            writer.write(game);
//            writer.close();
//    }   catch (IOException e) {
//            fail("Exception should not have been thrown");
//        }
//
//        }
    @Test
    void testReaderGeneralGame() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralGame.json");
        try {
            Game game = reader.read();

            assertEquals("G1", game.getProjectName());
            assertEquals(10, game.getDaysToFinishWork());
            assertEquals(3, game.getEachDayAllowedTime());
            int index = 0;

            for (Student s : students.getStuList()) {
                Student readStudent = game.getListOfStudents().get(index);
                assertEquals(s.getName(), readStudent.getName());
                int internalIndex = 0;
                for (PersonalTask pt : s.getPersonalTasks()) {
                    PersonalTask readPersonalTask = readStudent.getPersonalTasks().get(internalIndex);
                    assertEquals(pt.getName(),readPersonalTask.getName());
                    assertEquals(pt.getActionToFinishTask(),readPersonalTask.getActionToFinishTask());
                    assertEquals(pt.getTimeRequired(),readPersonalTask.getTimeRequired());
                    internalIndex++;
                }
                internalIndex = 0;
                for (TeamTask tt : s.getTeamTask()) {
                    TeamTask readTeamTask  = readStudent.getTeamTask().get(internalIndex);
                    assertEquals(tt.getName(),readTeamTask.getName());
                    assertEquals(tt.getTimeRequired(),readTeamTask.getTimeRequired());
                    internalIndex++;
                }
                index++;
            }
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

}
