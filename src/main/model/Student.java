package model;

import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;
import java.util.Arrays;

// *** you need these

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

//represents a Student, with name, teamTask, and personalTasks
public class Student implements Writable {
    private String name;
    private ArrayList<TeamTask> teamTask;
    private ArrayList<PersonalTask> personalTasks;



    public Student(String studentName,
                   String teamTaskInitial,
                   int requiredDays,
                   String personalTaskInitial,
                   String actionForPersonalTask, int timeForPersonalTask) {
        name = studentName;
        teamTask = new ArrayList<>(Arrays.asList(new TeamTask(teamTaskInitial, requiredDays)));
        personalTasks = new ArrayList<>(Arrays.asList(new PersonalTask(personalTaskInitial,
                actionForPersonalTask, timeForPersonalTask)));

    }

    // MODIFIES : this
    // EFFECT   : add given personalTask to the list of personalTask of this

    public void addPersonalTask(String newTaskName, String actionRequired, int timeForPersonalTask) {
        personalTasks.add(new PersonalTask(newTaskName, actionRequired, timeForPersonalTask));
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

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name",name);
        json.put("teamTask",teamTaskToJson());
        json.put("personalTasks",personalTasksToJson());

        return json;
    }

    private JSONArray teamTaskToJson() {
        JSONArray jsonArray = new JSONArray();

        for (TeamTask t : teamTask) {
            jsonArray.put(t.toJson());
        }

        return jsonArray;
    }

    private JSONArray personalTasksToJson() {
        JSONArray jsonArray = new JSONArray();

        for (PersonalTask pt : personalTasks) {
            jsonArray.put(pt.toJson());
        }

        return jsonArray;
    }
}
