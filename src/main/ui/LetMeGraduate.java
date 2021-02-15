package ui;

import model.*;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class LetMeGraduate {
    // EFFECTS : return user input
    public int getUserInputInt() {
        Scanner scanner = new Scanner(System.in);
        int userInput = scanner.nextInt();
        return userInput;
    }

    public String getUserInputString() {
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.next();
        return userInput;

    }

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

    private Game g1 = new Game("CPSC 210 PRESENTATION", new ArrayList<>(Arrays.asList(s1, s2, s3, s4)));

    //list of strings for ui text operation

    private ArrayList<String> listOfPersonalTaskNameString = new ArrayList<>();
    private ArrayList<String> listOfPersonalTaskActionString = new ArrayList<>();
    private ArrayList<String> listOfPersonalTaskRequiredTimeString = new ArrayList<>();

    //getters
    public ArrayList<String> getListOfPersonalTaskActionString() {
        return listOfPersonalTaskActionString;
    }

    public ArrayList<String> getListOfPersonalTaskNameString() {
        return listOfPersonalTaskNameString;
    }

    public ArrayList<String> getListOfPersonalTaskRequiredTimeString() {
        return listOfPersonalTaskRequiredTimeString;
    }

    //setter
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
        //StartGame
        startGame();
    }


    // MODIFIES : This
    // EFFECTS  : welcome user and give initial information about the game
    public void createGame() {
        welcomeCreate();
        displayBasicTimeInfo();
        seeTeamMates();
    }

    // EFFECTS : welcome user and create a game
    public void welcomeCreate() {
        System.out.println("WELCOME! To Create a New Game, enter '210'");
        String typeAnyKey = getUserInputString();
        System.out.println("You pressed" + " " + typeAnyKey);

        while (typeAnyKey.equals("quit") != true) {
            if (typeAnyKey.equals("210")) {
                System.out.println("Creating Team Members...");
                System.out.println("Creating Team Tasks...");
                break;
            } else {
                System.out.println("Try again, to exit, type 'quit'");
                typeAnyKey = this.getUserInputString();
            }
        }

        if (typeAnyKey.equals("quit")) {
            System.out.println("You cannot quit your team project :)");
            System.out.println("Creating Team Members...");
            System.out.println("Creating Team Tasks...");
        }
    }

    // EFFECTS : gives time info about the game
    public void displayBasicTimeInfo() {
        System.out.println("Enter 'a' to progress");

        if (getUserInputString().equals("a")) {
            System.out.println(
                    "Project Name: " + g1.getProjectName() + "\n"
                            + "Days   Given: " + Integer.toString(g1.getDaysToFinishWork()) + "\n"
                            + "You Can Work: " + Integer.toString(g1.getEachDayAllowedTime()) + " hours a day" + "\n"
            );
        }

    }

    // EFFECTS : displays teammates info
    public void seeTeamMates() {
        String formatTeamMate = giveFormatForStudentDisplay();

        if (getUserInputString().equals("a")) {
            System.out.println("Your Teammates are :");
            System.out.format(
                    formatTeamMate,
                    "Name",
                    "Role In Team",
                    "Days Needed for the Role",
                    "Dealing with",
                    "Time Needed to deal with it");
            System.out.println();
            System.out.println();
            for (Student s : g1.getListOfStudents()) {
                System.out.format(
                        formatTeamMate,
                        s.getName(),
                        s.getTeamTask().get(0).getName(),
                        s.getTeamTask().get(0).getDaysRequired(),
                        s.getPersonalTasks().get(0).getName(),
                        s.getPersonalTasks().get(0).getTimeRequiredToFinishTask());
                System.out.println();
            }

        }
    }

    // EFFECTS : returns format for the formatting of the teammates
    public String giveFormatForStudentDisplay() {
        System.out.println("Enter 'a' to see teammates");
        String teamMatesCol1 = "%-27.27s";
        String teamMatesCol2 = "%-27.27s";
        String teamMatesCol3 = "%-27.27s";
        String teamMatesCol4 = "%-27.27s";
        String teamMatesCol5 = "%-27.27s";

        String formatTeamMate = teamMatesCol1 + " " + teamMatesCol2 + " " + teamMatesCol3 + " "
                + teamMatesCol4 + " " + teamMatesCol5;

        return formatTeamMate;
    }

    // EFFECTS : let the user start the game
    public void startGame() {
        System.out.println("To start the project, enter 'a'");
        if (getUserInputString().equals("a")) {
            runGameLoop();
        }
    }


    // MODIFIES : This
    // EFFECTS  : run game till all team task is done or the due date is over
    public void runGameLoop() {
        while (true == true) {
            this.informationTab();
            this.chooseAction();

            //b.c.of break, cannot be put in the helper.
            if (g1.isAllTeamTasksDoneBeforeDue()) {
                System.out.println("congrats! you passed this group project");
                break;
            } else if (g1.getCurrentDay() >= g1.getDaysToFinishWork()) {
                System.out.println("oh... you failed this group project... try again");
                break;
            }
        }
    }

    // MODIFIES: This
    // EFFECTS : display actions of choice and process the action
    public void informationTab() {
        showDateInfo();
        setPersonalTaskStrings();
        showCurrentProgress();
    }

    // EFFECTS : display current date info, day and time
    public void showDateInfo() {
        System.out.println("Day : " + Integer.toString(g1.getCurrentDay()));
        System.out.println("Time: " + Integer.toString(g1.getCurrentTime()));
    }

    // EFFECTS : display current progression of personal/team task
    public void showCurrentProgress() {
        System.out.println("Current Progress: ");
        //showing personal tasks
        showPersonalTaskProgress();

        //showing team task
        showTeamTaskProgress();

    }

    // EFFECT : display current progression of personal task
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

    // EFFECT : display current progression of team task
    public void showTeamTaskProgress() {
        int maxCol1 = maxCharacterPerColumn();
        String teamTaskInfoFormatCol1 = "%-" + Integer.toString(maxCol1) + "." + Integer.toString(maxCol1) + "s";
        String teamTaskInfoFormatCol2 = "%-" + "1" + ".21" + "s";
        String teamTaskInfoFormat = teamTaskInfoFormatCol1 + " | " + teamTaskInfoFormatCol2;
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

    // EFFECT : return max character for the formatting of the showTeamTaskProgress()
    public int maxCharacterPerColumn() {
        int maxCol1 = 0;
        //max9days for team task.
        for (TeamTask tt : g1.getListOfTeamTask()) {
            if (tt.getName().length() > maxCol1) {
                maxCol1 = tt.getName().length();
            }
        }
        return maxCol1;
    }

    // MODIFIES : this
    // EFFECTS   : let user choose actions from displayed ones
    public void chooseAction() {
        displayActions();
        processActions();
    }

    // EFFECTS : display available actions for a user
    public void displayActions() {
        System.out.println("Choose an action from :");

        int index = 0;

        for (String s : getListOfPersonalTaskNameString()) {
            System.out.print("_______________________________" + "\n");
            System.out.println(Integer.toString(index) + " " + getListOfPersonalTaskActionString().get(index));

            index++;
        }
    }

    // MODIFIES : this
    // EFFECTS : get user's choice of action and process the action
    public void processActions() {
        System.out.println("Enter Your Choice(1,2,3,4,...) or 0 for progressing to next day");

        int choice = getUserInputInt();

        if (choice == 0) {
            g1.progressToNextTime();
        } else {
            System.out.println("You choose: " + g1.getListOfPersonalTask().get(choice - 1).getActionToFinishTask());
            g1.finishAPersonalTask(g1.getListOfPersonalTask().get(choice - 1).getActionToFinishTask());
            System.out.println(g1.getListOfPersonalTask());
        }
    }
}


