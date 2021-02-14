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
        teamTask = new ArrayList<>(Arrays.asList(new TeamTask(teamTaskInitial, requiredDays)));
        personalTasks = new ArrayList<>(Arrays.asList(new PersonalTask(personalTaskInitial,
                actionForPersonalTask)));

    }

    // MODIFIES : this
    // EFFECT   : add given personalTask to the list of personalTask of this

    public void addPersonalTask(String newTaskName, String actionRequired) {
        personalTasks.add(new PersonalTask(newTaskName, actionRequired));
    }

    // MODIFIES : this
    // EFFECT   : remove given personalTask to the list of personalTask of this if the task exists and the actions for
    // the test removal is done, else, nothing

    public void removePersonalTask(String existingTaskName, String action) {
        //creating clone for the PersonalTasks since remove() in for loop changes its index and cause error
        ArrayList<PersonalTask> clonePersonalTasks = new ArrayList<>();
        for (PersonalTask p : personalTasks) {
            clonePersonalTasks.add(p);
            if ((p.getName() == existingTaskName) && (p.getActionToFinishTask() == action)) {
                clonePersonalTasks.remove(p);
            }
        }
        personalTasks = clonePersonalTasks;
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
