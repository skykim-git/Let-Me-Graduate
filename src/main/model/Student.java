package model;

import java.util.ArrayList;
import java.util.Arrays;

//represents a Student, with name, teamTask, and personalTasks
public class Student {
    private String name;
    private ArrayList<TeamTask> teamTask;
    private ArrayList<PersonalTask> personalTasks;



    public Student(String studentName, String teamTaskInitial, int requiredDays, String personalTaskInitial,
                   String actionForPersonalTask) {
        name = studentName;
        teamTask = new ArrayList<TeamTask>(Arrays.asList(new TeamTask(teamTaskInitial, requiredDays)));
        personalTasks = new ArrayList<PersonalTask>(Arrays.asList(new PersonalTask(personalTaskInitial,
                actionForPersonalTask)));

    }

    // MODIFIES : this
    // EFFECT   : add given personalTask to the list of personalTask of this

    public void addPersonalTask(String newTaskName, String action) {
        personalTasks.add(new PersonalTask(newTaskName,action));
    }

    // MODIFIES : this
    // EFFECT   : remove given personalTask to the list of personalTask of this if the task exists and the actions for
    // the test removal is done, else, nothing

    public void removePersonalTask(String existingTaskName, String action) {
        for (PersonalTask p : personalTasks) {
            if (p.getName() == existingTaskName && p.getActionToFinishTask() == action) {
                personalTasks.remove(p);
            }
        }
    }

    public String getName() {
        return this.name;
    }

    public ArrayList<TeamTask> getTeamTask() {
        return this.teamTask;
    }

    public ArrayList<PersonalTask> getPersonalTasks() {
        return this.personalTasks;
    }








}
