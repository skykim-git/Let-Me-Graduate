package ui;

import java.io.File;
import java.io.FileNotFoundException;

//runs LetMeGraduate
public class Main {
    public static void main(String[] args) {
        try {
            new LetMeGraduate();
        } catch (FileNotFoundException e) {
            System.out.println("Unable to run application: file not found");
        }


    }
}
