package model;

import java.util.ArrayList;

// *** you need these
import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

//represents a game, which has basic setting for a game and current progress
public class Game implements Writable {
    private static int DaysToFinishWork;
    private static int EachDayAllowedTime;

    private String projectName;
    private StudentList listOfStudents;
    private ArrayList<TeamTask> listOfTeamTask;
    private ArrayList<PersonalTask> listOfPersonalTask;
    private ArrayList<String> actionsForPersonalTask;

    private int currentDay;
    private int currentTime;

    public Game(String pjName, StudentList los) {
        //constructor has no return type
        DaysToFinishWork = 10;
        EachDayAllowedTime = 3;
        projectName = pjName;
        listOfStudents = los;
        listOfTeamTask = new ArrayList<>();
        listOfPersonalTask = new ArrayList<>();
        actionsForPersonalTask =  new ArrayList<>();

        //create list of availableActions and listOfTeamTask for future computation
        for (Student s : los.getStuList()) {
            for (PersonalTask task : s.getPersonalTasks()) {
                actionsForPersonalTask.add(task.getActionToFinishTask());
                listOfPersonalTask.add(task);
            }
            for (TeamTask task : s.getTeamTask()) {
                listOfTeamTask.add(task);
            }
        }

        currentDay = 1;
        currentTime = 1;

    }

    // MODIFIES : this
    // EFFECTS  : progress to next day in a game
    public void progressToNextDay() {
        currentDay++;
    }

    // MODIFIES : this
    // EFFECTS  : progress to next time by 1, if is the last time of the day.
    //            progress to first time of tomorrow. and call doTeamTasks
    public void progressToNextTime() {
        if (currentTime + 1 > EachDayAllowedTime) {
            this.progressToNextDay();
            currentTime = 1;
        } else {
            currentTime++;
        }
        this.doTeamTasks();
    }

    // MODIFIES : this
    // EFFECTS  : finish a personal task (by setting requiredTime of pt as 0) and progress time and date depending on
    //            the time taken
    public void finishAPersonalTask(String actionName) {
        //set required time for personal task to zero, and get the time required
        int timeUsed;
        for (PersonalTask p : listOfPersonalTask) {
            if (p.getActionToFinishTask().equals(actionName)) {
                //get required time
                timeUsed = p.getTimeRequired();
                //change time should happen before finishAPersonalTask change a timerequired to zero -> double reduction
                for (int i = 1; i <= timeUsed; i++) {
                    this.progressToNextTime();
                }
                //set required time to zero
                p.setTimeRequiredToFinishTaskToZero();

            }
        }


        //remake two lists about the personal tasks(up
        ArrayList<PersonalTask> cloneListOfPersonalTask = new ArrayList<>();
        ArrayList<String>       cloneAvailableActions   = new ArrayList<>();
        for (PersonalTask p : listOfPersonalTask) {
            if (p.getTimeRequired() != 0) {
                cloneListOfPersonalTask.add(p);
                cloneAvailableActions.add(p.getName());
            }
        }

        //change original two lists to the new ones
        listOfPersonalTask = cloneListOfPersonalTask;
        actionsForPersonalTask = cloneAvailableActions;

    }

    // MODIFIES : this
    // EFFECTS  : if there is a student who's personal task is done, as we progress time, the student's task time is
    // automatically reduced


    public void doTeamTasks() {
        ArrayList<TeamTask> cloneListOfTeamTask = new ArrayList<>();
        for (Student s : listOfStudents.getStuList()) {
            int allDone = 0;
            for (PersonalTask pt : s.getPersonalTasks()) {
                if (pt.getTimeRequired() == 0) {
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

    // EFFECTS  : if all team tasks are done before the due date(team tasks all have 0 required time)
    //             return true, otherwise, false

    public boolean isAllTeamTasksDoneBeforeDue() {
        //don't know what's wrong
        boolean allTeamTaskDone = false;
        int zeroCount = 0;

        for (TeamTask teamTask : listOfTeamTask) {
            if (teamTask.getTimeRequired() == 0) {
                zeroCount++;
            }
        }
        if (listOfTeamTask.size() == zeroCount) {
            allTeamTaskDone = true;
        }

        boolean beforeDue;
        beforeDue = currentDay <= getDaysToFinishWork();

        return (allTeamTaskDone && beforeDue);
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
        return listOfStudents.getStuList();
    }

    public ArrayList<String> getActionsForPersonalTask() {
        return actionsForPersonalTask;
    }

    public ArrayList<TeamTask> getListOfTeamTask() {
        return listOfTeamTask;
    }

    public ArrayList<PersonalTask> getListOfPersonalTask() {
        return listOfPersonalTask;
    }

    public int getCurrentDay() {
        return currentDay;
    }

    public int getCurrentTime() {
        return currentTime;
    }


    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        //no need for additional functions
        json.put("DaysToFinishWork", DaysToFinishWork);
        json.put("EachDayAllowedTime",EachDayAllowedTime);
        json.put("projectName",projectName);
        json.put("currentDay",currentDay);
        json.put("currentTime",currentTime);
        //needs functions
        json.put("listOfStudents",studentsToJson());
        json.put("listOfTeamTask",teamTasksToJson());
        json.put("listOfPersonalTask",personalTaskToJson());
        json.put("actionsForPersonalTask",actionsForPersonalTaskToJson());

        return json;
    }

    private JSONArray studentsToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Student s : listOfStudents.getStuList()) {
            jsonArray.put(s.toJson());
        }

        return jsonArray;
    }

    private JSONArray teamTasksToJson() {
        JSONArray jsonArray = new JSONArray();

        for (TeamTask tt : listOfTeamTask) {
            jsonArray.put(tt.toJson());
        }

        return jsonArray;
    }

    private JSONArray personalTaskToJson() {
        JSONArray jsonArray = new JSONArray();

        for (PersonalTask pt : listOfPersonalTask) {
            jsonArray.put(pt.toJson());
        }

        return jsonArray;
    }

    private JSONArray actionsForPersonalTaskToJson() {
        JSONArray jsonArray = new JSONArray();

        for (String act : actionsForPersonalTask) {
            jsonArray.put(act);
        }

        return jsonArray;
    }

    //setters

    public void setListOfPersonalTask(ArrayList<PersonalTask> personalTask) {
        this.listOfPersonalTask = personalTask;
    }

    public void setActionsForPersonalTask(ArrayList<String> actions) {
        this.actionsForPersonalTask = actions;

    }

    public void setDaysToFinishWork(int day) {
        DaysToFinishWork = day;
    }

    public void setEachDayAllowedTime(int allowedTime) {
        EachDayAllowedTime = allowedTime;
    }

    public void setCurrentDay(int t) {
        currentTime = t;
    }

    public void setCurrentTime(int d) {
        currentDay = d;

    }






}
