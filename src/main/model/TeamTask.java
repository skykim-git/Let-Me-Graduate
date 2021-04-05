package model;

import org.json.JSONObject;
import persistence.Writable;

//represent a teamTask, which has name and days Required.
public class TeamTask extends Task {

    public TeamTask(String taskName, int days) {
        super(taskName, days);
    }

    // EFFECTS : reduce days required by one, if hit zero, keep it zero
    public void reduceDaysRequiredByOne() {
        if (this.timeRequired - 1 >= 0) {
            timeRequired--;
        } else {
            timeRequired = 0;
        }
    }
    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();

        json.put("name",name);
        json.put("daysRequired",timeRequired);

        return json;
    }



}
