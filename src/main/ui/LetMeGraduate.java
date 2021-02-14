package ui;

import model.Game;
import model.PersonalTask;
import model.Student;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class LetMeGraduate {
    private Student s1 = new Student(
            "David",
            "Make powerpoint",
            3,
            "Not in a mood to work on a project",
            "Eat Chocolate Chip Together",
            1);

    private Student s2 = new Student(
            "Kori",
            "Do research",
            3,
            "Preparing 3 other midterms",
            "Help Studying!",
            3);

    private Student s3 = new Student(
            "Rachel",
            "Prepare presentation script",
            3,
            "Moving out today",
            "Help Moving out!",
            6);

    private Student s4 = new Student(
            "Me",
            "Do presentation",
            3,
            "Nothing",
            "Nothing",
            0);

    private Game g1 = new Game("CPSC 210 PRESENTATION", new ArrayList<>(Arrays.asList(s1,s2,s3,s4)));

    //EFFECTS : runs the LetMeGraduate application
    public LetMeGraduate() {
        runLetMeGraduate();
    }

    // MODIFIES : this
    // EFFECTS  : runs the game till it ends
    public void runLetMeGraduate() {
        //CreateGame
        createGame();
        //GameLoop
        runGameLoop();


    }

    public void createGame() {
        System.out.println("WELCOME! Create a New Game!");
        System.out.println("Project : " + g1.getProjectName() + "\n"
                + Integer.toString(g1.getDaysToFinishWork()) + " days are given" + "\n"
                + "you can work " + Integer.toString(g1.getEachDayAllowedTime()) + " hours a day" + "\n"
        );

        System.out.println("Your Teammates are :");
        for (Student s : g1.getListOfStudents()) {
            System.out.println("Name: " + s.getName() + "\n"
                    + "Role In Team: " + s.getTeamTask().get(0).getName() + "\n"
                    + "Days Needed for the Role: " + s.getTeamTask().get(0).getDaysRequired() + "\n"
                    + "Dealing with: " + s.getPersonalTasks().get(0) + "\n"
                    + "Time Needed to deal with it: "
                    + s.getPersonalTasks().get(0).getTimeRequiredToFinishTask() + "\n");
        }
    }

    public void runGameLoop() {
        while (//g1.isAllTeamTasksDoneBeforeDue() == false && g1.getCurrentDay() <= g1.getDaysToFinishWork()
                true == true
        ) {
            System.out.println("Day : " + Integer.toString(g1.getCurrentDay()));
            System.out.println("Time: " + Integer.toString(g1.getCurrentTime()));
            ArrayList<String> listOfPersonalTaskName = new ArrayList<>();
            ArrayList<String> listOfPersonalTaskAction = new ArrayList<>();
            ArrayList<String> listOfPersonalTaskRequiredTime = new ArrayList<>();
            for (PersonalTask pt : g1.getListOfPersonalTask()) {

                listOfPersonalTaskName.add(pt.getName());

                listOfPersonalTaskAction.add(pt.getActionToFinishTask());

                listOfPersonalTaskRequiredTime.add(Integer.toString(pt.getTimeRequiredToFinishTask()));
            }
            System.out.println("Current Progress: ");
            int index = 0;
            for (String s : listOfPersonalTaskName) {
                System.out.print("_______________" + "\n");
                System.out.print("\t");
                System.out.println(listOfPersonalTaskName.get(index));
                System.out.print("\t");
                System.out.println(listOfPersonalTaskAction.get(index));
                System.out.print("\t");
                System.out.println(listOfPersonalTaskRequiredTime.get(index));

                index++;
            }

            System.out.println("Choose an action from :");
            index = 0;

            for (String s : listOfPersonalTaskName) {
                System.out.print("_______________" + "\n");
                System.out.print("\t");
                System.out.println(listOfPersonalTaskAction.get(index));

                index++;
            }
            System.out.println("Enter Your Choice(1,2,3,4,...) or 0 for progressing to next day");
            int choice = getUserInPut();
            if (choice == 0) {
                g1.progressToNextTime();
            } else {
                System.out.println("You choose: " + g1.getListOfPersonalTask().get(choice - 1).getActionToFinishTask());
                g1.finishAPersonalTask(g1.getListOfPersonalTask().get(choice - 1).getActionToFinishTask());
            }

            if (g1.isAllTeamTasksDoneBeforeDue()) {
                System.out.println("congrats! you passed this group project");
                break;
            } else if (g1.getCurrentDay() >= g1.getDaysToFinishWork()) {
                System.out.println("oh... you failed this group project... try again");
                break;
            }

        }

    }

    public int getUserInPut() {
        Scanner choiceScanner = new Scanner(System.in);
        int choice = choiceScanner.nextInt();
        return choice;
    }

    public void startGame() {


    }
}
