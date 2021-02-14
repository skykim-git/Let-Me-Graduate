package model;

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
        currentDay++;

    }

    // REQUIRES :
    // MODIFIES :
    // EFFECTS  :


    // REQUIRES :
    // MODIFIES : this
    // EFFECTS  : if a player does an action(choosing from options). progress to next time, if is the last time
    //            progress to the tomorrow first time. and call doTeamTasks
    public void progressToNextTime() {
        if (currentTime + 1 > EachDayAllowedTime) {
            this.progressToNextDay();
            currentTime = 1;
        } else {
            currentTime++;
        }
        this.doTeamTasks();
    }


    // REQUIRES :
    // MODIFIES : this
    // EFFECTS  : finish a personal task (by getting rid of a p.t. in the list) and progress time and date depending on
    //            the time taken
    public void finishAPersonalTask(String actionName) {
        //set required time for personal task to zero, and get the time required
        int timeUsed = 0;
        for (PersonalTask p : listOfPersonalTask) {
            if (p.getActionToFinishTask() == actionName) {
                //get required time
                timeUsed = p.getTimeRequiredToFinishTask();
                //change time should happen before finishAPersonalTask change a timerequired to zero -> double reduction
                for (int i = 1; i <= timeUsed ; i++) {
                    this.progressToNextTime();
                }
                //set required time to zero
                p.setTimeRequiredToFinishTaskToZero();

            }
        }




        //remake two lists about the personal tasks
        ArrayList<PersonalTask> cloneListOfPersonalTask = new ArrayList<>();
        ArrayList<String>       cloneAvailableActions   = new ArrayList<>();
        for (PersonalTask p : listOfPersonalTask) {
            if (p.getTimeRequiredToFinishTask() != 0) {
                cloneListOfPersonalTask.add(p);
                cloneAvailableActions.add(p.getName());
            }
        }

        //change original two lists to the new ones
        listOfPersonalTask = cloneListOfPersonalTask;
        availableActions   = cloneAvailableActions;



    }



    // REQUIRES :
    // MODIFIES : this
    // EFFECTS  : if there is a student who's personal task is done, as we progress time, the student's task time is
    // automatically reduced


    public void doTeamTasks() {
        ArrayList<TeamTask> cloneListOfTeamTask = new ArrayList<>();
        for (Student s : listOfStudents) {
            int allDone = 0;
            for (PersonalTask pt : s.getPersonalTasks()) {
                if (pt.getTimeRequiredToFinishTask() == 0) {
                    //to check if all personal task is done
                    allDone++;
                }
            }
            // if all personal task is done
            if (allDone == s.getPersonalTasks().size()) {
                // reduce the required days for the team task for the student
                s.getTeamTask().get(0).reduceDaysRequiredByOne();
            }
            cloneListOfTeamTask.add(s.getTeamTask().get(0));
        }
        listOfTeamTask = cloneListOfTeamTask;

    }

    // REQUIRES :
    // MODIFIES :
    // EFFECTS  : print out the available actions that the player can do
    public void showAvailableActions() {
        //stub
    }
    // REQUIRES :
    // MODIFIES :
    // EFFECTS  : if all teamtasks are done before the due date(teamtasks all have 0 required time)
    // , return true, otherwise, false

    public boolean isAllTeamTasksDoneBeforeDue() {
        //don't know what's wrong
        boolean allTeamTaskDone = true;

        for (TeamTask teamTask : listOfTeamTask) {
            if (teamTask.getDaysRequired() != 0) {
                allTeamTaskDone = false;
            } else {
                allTeamTaskDone = true;
            }
        }
        boolean beforeDue;
        if (currentDay <= getDaysToFinishWork()) {
            beforeDue = true;
        } else {
            beforeDue = false;
        }

        if (allTeamTaskDone && beforeDue) {
            return true;
        } else {
            return false;
        }

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
