package ui;

import model.*;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.FileNotFoundException;
import java.io.IOException;
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

    private static final String JSON_STORE = "./data/myGame.txt";

    private StudentList stuList;

    public StudentList getStuList() {
        return stuList;
    }

    private Game g1;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;


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
    public LetMeGraduate() throws FileNotFoundException {
        // put all the constant (list definitions here...!)???
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
        runLetMeGraduate();
    }

    // MODIFIES : this
    // EFFECTS  : runs the game till it ends
    public void runLetMeGraduate() {
        //choose!!! load or new?
        System.out.print("To load, enter 'l', to start a new game, enter 'n'");
        String selection = getUserInputString();
        if (selection.equals("l")) {
            loadGame();
            runGameLoop();
        } else if (selection.equals("n")) {
            //CreateGame
            createGame();
            //StartGame
            startGame();
        }
    }


    // MODIFIES : This
    // EFFECTS  : welcome user and give initial information about the game
    public void createGame() {
        welcomeCreate();
        // set default Game
        setDefaultStuList();
        setGame();
        displayBasicTimeInfo();
        // add additionals
        addStudent();
        setGame();

        seeTeamMates();
    }

    // MODIFIES : this
    // EFFECTS  : put default students in the stuList and additional if chosen

    public void setDefaultStuList() {
        putStuInList();
    }

    // MODIFIES : this
    // EFFECTS  : put default students in the stuList

    public void setGame() {
        g1 = new Game("CPSC 210 PRESENTATION", stuList);
    }

    // makes the initial student list.
    public void putStuInList() {
        stuList = new StudentList();
        stuList.addStudent(s1);
        stuList.addStudent(s2);
        stuList.addStudent(s3);
        stuList.addStudent(s4);
    }

    public void putNewStudent1() {
        Student s5 = new Student(
                "Alex",
                "Lighting",
                3,
                "Have to learn Lighting",
                "Find a Lighting tutorial",
                1);
        stuList.addStudent(s5);
    }

    public void putNewStudent2() {
        Student s6 = new Student(
                "Micheal",
                "Proof Read the script",
                3,
                "Crying after previous test",
                "Serious soothing talk",
                2);
        stuList.addStudent(s6);
    }

    public void putNewStudent3() {
        Student s7 = new Student(
                "Tony",
                "Set the stage",
                3,
                "need some protein",
                "make protein shake",
                1);
        stuList.addStudent(s7);
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
                            + "Default Teammates: " + Integer.toString(g1.getListOfStudents().size()) +"\n"
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

    // EFFECTS : add #of students of user's input(number <3)
    public void addStudent() {
        //System.out.println("If you want to add another teammate, enter the number of team mates you want to add (< 3)");
        StudentSelectionPanel stuPanel = new StudentSelectionPanel(this);

//        if (stuPanel.getProgressOkay()) {
//            System.out.println("team setting done");
//        }

        String progressToGame = getUserInputString();

        if (progressToGame.equals("a")) {
            System.out.println("team setting done");
        }

//        String numMates = getUserInputString();
//
//        if (numMates.equals("0")) {
//            System.out.println("working with 4 team mates");
//        } else if (numMates.equals("1")) {
//            putNewStudent1();
//            System.out.println("working with 5 team mates");
//        } else if (numMates.equals("2")) {
//            putNewStudent1();
//            putNewStudent2();
//            System.out.println("working with 6 team mates");
//        } else if (numMates.equals("3")) {
//            putNewStudent1();
//            putNewStudent2();
//            putNewStudent3();
//            System.out.println("working with 7 team mates");
//        }

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
            System.out.println(Integer.toString(index + 1) + " " + getListOfPersonalTaskActionString().get(index));

            index++;
        }
    }

    // MODIFIES : this
    // EFFECTS : get user's choice of action and process the action
    public void processActions() {
        System.out.println("Enter Your Choice(1,2,3,4,...) or 0 for progressing to next day "
                + "or -1 to save progress " + "or 100 to load previous progress");

        int choice = getUserInputInt();

        if (choice == 0) {
            g1.progressToNextTime();
        } else if (choice == -1) {
            saveGame();
        } else if (choice == 100) {
            loadGame();
        } else {
            System.out.println("You choose: " + g1.getListOfPersonalTask().get(choice - 1).getActionToFinishTask());
            g1.finishAPersonalTask(g1.getListOfPersonalTask().get(choice - 1).getActionToFinishTask());
            System.out.println(g1.getListOfPersonalTask());
        }
    }

    // EFFECTS : save the current progress to "./data/myGame.txt"
    public void saveGame() {
        try {
            jsonWriter.open();
            jsonWriter.write(g1);
            jsonWriter.close();
            System.out.println("Saved " + g1.getProjectName() + " to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " +  JSON_STORE);
        }

    }

    // MODIFIES : this
    // EFFECTS : load the previous progress from "./data/myGame.txt"
    public void loadGame() {
        try {
            g1 = jsonReader.read();
            System.out.println("Loaded " + g1.getProjectName() + " from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }
}


