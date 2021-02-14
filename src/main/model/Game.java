package model;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Game {
    private static int DaysToFinishWork;
    private static int EachDayAllowedTime;

    private String projectName;
    private ArrayList<Student> listOfStudents;
    private ArrayList<String>  availableActions;
    private ArrayList<TeamTask> listOfTeamTask;
    private ArrayList<PersonalTask> listOfPersonalTask;
    private boolean allTaskDone;
    private int currentDay;
    private int currentTime;

    public Game(String pjName, ArrayList<Student> los) {
        //constructor has no return type
        DaysToFinishWork = 10;
        EachDayAllowedTime = 3;
        projectName = pjName;
        listOfStudents = los;
        availableActions =  new ArrayList<>();
        listOfPersonalTask = new ArrayList<>();
        listOfTeamTask = new ArrayList<>();
        //create list of availableActions and listOfTeamTask for future computation
        for (Student s : los) {
            for (PersonalTask task : s.getPersonalTasks()) {
                availableActions.add(task.getActionToFinishTask());
                listOfPersonalTask.add(task);
            }
            for (TeamTask task : s.getTeamTask()) {
                listOfTeamTask.add(task);
            }
        }
        allTaskDone = false;
        currentDay = 1;
        currentTime = 1;

    }

    // REQUIRES
    // MODIFIES : this
    // EFFECTS  : progress to next day in a game if the current time is over the given time a day.
    public void progressToNextDay() {
        //stub

    }

    // REQUIRES :
    // MODIFIES :
    // EFFECTS  :


    // REQUIRES :
    // MODIFIES : this
    // EFFECTS  : if a player does an action(choosing from options). progress to next time, if is the last time
    //            progress to the tomorrow first time.
    public void progressToNextTime() {
        //stub
    }

    // REQUIRES :
    // MODIFIES : this
    // EFFECTS  : finish a personal task (by getting rid of a p.t. in the list)
    public void finishAPersonalTask(String TaskName) {
        //stub
    }

    public void finishATeamTask() {

    }

    // REQUIRES :
    // MODIFIES :
    // EFFECTS  : print out the available actions that the player can do
    public void showAvailableActions() {
        //stub
    }
    // REQUIRES :
    // MODIFIES :
    // EFFECTS  : if all teamtasks are done before the due date, return true, otherwise, false

    public boolean isAllTeamTasksDone() {
        //stub
        return false;
    }
    // REQUIRES :
    // MODIFIES : this
    // EFFECTS  : if the date <= given date, and if all teamTasks are done, print "success", else "fail"

    public void finishGame() {
        //stub
    }

    //getters

    public int getDaysToFinishWork() {
        return DaysToFinishWork;
    }

    public int getEachDayAllowedTime() {
        return EachDayAllowedTime;
    }

    public String getProjectName() {
        return projectName;
    }

    public ArrayList<Student> getListOfStudents() {
        return listOfStudents;
    }

    public ArrayList<String> getAvailableActions() {
        return availableActions;
    }

    public ArrayList<TeamTask> getListOfTeamTask() {
        return listOfTeamTask;
    }

    public ArrayList<PersonalTask> getListOfPersonalTask() {
        return listOfPersonalTask;
    }

    public boolean getAllTaskDone() {
        return allTaskDone;
    }

    public int getCurrentDay() {
        return currentDay;
    }

    public int getCurrentTime() {
        return currentTime;
    }




}
