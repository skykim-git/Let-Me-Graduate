package model;

import org.json.JSONObject;
import persistence.Writable;

//represents a personal Task which has name, actionToFinishTask, and timeRequired to finish task.
public class PersonalTask extends Task {
    private String actionToFinishTask;

    public PersonalTask(String taskName, String action, int time) {
        super(taskName, time);
        actionToFinishTask = action;
    }

    public String getActionToFinishTask() {
        return this.actionToFinishTask;
    }

    public void setTimeRequiredToFinishTaskToZero() {
        this.timeRequired = 0;
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();

        json.put("name",name);
        json.put("actionToFinishTask",actionToFinishTask);
        json.put("timeRequiredToFinishTask",this.timeRequired);

        return json;
    }
}
