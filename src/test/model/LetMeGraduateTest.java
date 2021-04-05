package model;

import org.junit.jupiter.api.Test;
import ui.LetMeGraduate;

import java.io.FileNotFoundException;

public class LetMeGraduateTest {

    @Test
    public void processActionsTest() {

        try {
            new LetMeGraduate();
        } catch (FileNotFoundException e) {
            System.out.println("Unable to run application: file not found");
        }

    }
}
