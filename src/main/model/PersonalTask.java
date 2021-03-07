package model;

import org.json.JSONObject;
import persistence.Writable;
import sun.tools.jstat.Jstat;

public class PersonalTask implements Writable {
    private String name;
    private String actionToFinishTask;
    private int timeRequiredToFinishTask;

    public PersonalTask(String taskName, String action, int time) {
        name = taskName;
        actionToFinishTask = action;
        timeRequiredToFinishTask = time;
    }

    public String getName() {
        return this.name;
    }

    public String getActionToFinishTask() {
        return this.actionToFinishTask;
    }

    public int getTimeRequiredToFinishTask() {
        return this.timeRequiredToFinishTask;
    }

    public void setTimeRequiredToFinishTaskToZero() {
        timeRequiredToFinishTask = 0;
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();

        json.put("name",name);
        json.put("actionToFinishTask",actionToFinishTask);
        json.put("timeRequiredToFinishTask",timeRequiredToFinishTask);

        return json;
    }
}
