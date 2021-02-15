package ui;

import model.Game;
import model.PersonalTask;
import model.Student;
import model.TeamTask;

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


    public ArrayList<String> getListOfPersonalTaskActionString() {
        return listOfPersonalTaskActionString;
    }

    public ArrayList<String> getListOfPersonalTaskNameString() {
        return listOfPersonalTaskNameString;
    }

    public ArrayList<String> getListOfPersonalTaskRequiredTimeString() {
        return listOfPersonalTaskRequiredTimeString;
    }
    //list of strings for ui text operation

    private ArrayList<String> listOfPersonalTaskNameString = new ArrayList<>();
    private ArrayList<String> listOfPersonalTaskActionString = new ArrayList<>();
    private ArrayList<String> listOfPersonalTaskRequiredTimeString = new ArrayList<>();

    public void setPersonalTaskStrings() {
        //clear the list before
        this.getListOfPersonalTaskNameString().clear();
        this.getListOfPersonalTaskActionString().clear();
        this.getListOfPersonalTaskRequiredTimeString().clear();

        for (PersonalTask pt : g1.getListOfPersonalTask()) {
            //set the new string
            this.getListOfPersonalTaskNameString().add(pt.getName());

            this.getListOfPersonalTaskActionString().add(pt.getActionToFinishTask());

            this.getListOfPersonalTaskRequiredTimeString().add(Integer.toString(pt.getTimeRequiredToFinishTask()));
        }

    }

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

    // MODIFIES : This
    // EFFECTS  : welcome user and give initial information about the game

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
        while (true == true) {

            // informationTab

            this.informationTab();

            chooseAction();

            if (g1.isAllTeamTasksDoneBeforeDue()) {
                System.out.println("congrats! you passed this group project");
                break;
            } else if (g1.getCurrentDay() >= g1.getDaysToFinishWork()) {
                System.out.println("oh... you failed this group project... try again");
                break;
            }

        }

    }

    public void chooseAction() {
        System.out.println("Choose an action from :");
        int index = 0;

        for (String s : getListOfPersonalTaskNameString()) {
            System.out.print("_______________" + "\n");
            System.out.print("\t");
            System.out.println(getListOfPersonalTaskActionString().get(index));

            index++;
        }
        System.out.println("Enter Your Choice(1,2,3,4,...) or 0 for progressing to next day");
        int choice = getUserInPut();
        if (choice == 0) {
            g1.progressToNextTime();
        } else {
            System.out.println("You choose: " + g1.getListOfPersonalTask().get(choice - 1).getActionToFinishTask());
            g1.finishAPersonalTask(g1.getListOfPersonalTask().get(choice - 1).getActionToFinishTask());
            System.out.println(g1.getListOfPersonalTask());
        }

    }

    public void informationTab() {
        showDateInfo();
        setPersonalTaskStrings();
        showCurrentProgress();
    }

    public void showDateInfo() {
        System.out.println("Day : " + Integer.toString(g1.getCurrentDay()));
        System.out.println("Time: " + Integer.toString(g1.getCurrentTime()));
    }

    public void showCurrentProgress() {
        System.out.println("Current Progress: ");

        //showing personal tasks
        showPersonalTaskProgress();

        //showing team task
        showTeamTaskProgress();

    }

    public void showPersonalTaskProgress() {
        int index = 0;
        System.out.println(getListOfPersonalTaskNameString());
        for (String s : getListOfPersonalTaskNameString()) {
            System.out.print("_______________" + "\n");
            System.out.print("\t");
            System.out.println(getListOfPersonalTaskNameString().get(index));
            System.out.print("\t");
            System.out.println(getListOfPersonalTaskActionString().get(index));
            System.out.print("\t");
            System.out.println(getListOfPersonalTaskRequiredTimeString().get(index));

            index++;
        }

    }

    public void showTeamTaskProgress() {
        int maxCol1 = getMaxCharacterPerColumn();
        String teamTaskInfoFormatCol1 = "%-" + Integer.toString(maxCol1) + "." + Integer.toString(maxCol1) + "s";
        String teamTaskInfoFormatCol2 = "%-" + "1" + ".21" + "s";
        String teamTaskInfoFormat = teamTaskInfoFormatCol1 + " | " + teamTaskInfoFormatCol2;
        System.out.println(teamTaskInfoFormat);
        System.out.format(teamTaskInfoFormat, "Task ", "Days To Work More On");
        System.out.println();
        System.out.print("_____________________________________________________");
        System.out.println();


        for (TeamTask tt : g1.getListOfTeamTask()) {
            System.out.printf(
                    teamTaskInfoFormat,
                    tt.getName(),
                    Integer.toString(tt.getDaysRequired()));
            System.out.println();

        }

        System.out.println();

    }

    public int getMaxCharacterPerColumn() {
        int maxCol1 = 0;
        //max9days for team task.
        for (TeamTask tt : g1.getListOfTeamTask()) {
            if (tt.getName().length() > maxCol1) {
                maxCol1 = tt.getName().length();
            }
        }
        return maxCol1;

    }

    public int getUserInPut() {
        Scanner choiceScanner = new Scanner(System.in);
        int choice = choiceScanner.nextInt();
        return choice;
    }

}
