package model;

import org.json.JSONObject;
import persistence.Writable;

//represent a teamTask, which has name and days Required.
public class TeamTask implements Writable {
    private String name;
    private int daysRequired;

    public TeamTask(String taskName, int days) {
        name = taskName;
        daysRequired = days;
    }

    // EFFECTS : reduce days required by one, if hit zero, keep it zero
    public void reduceDaysRequiredByOne() {
        if (daysRequired - 1 >= 0) {
            daysRequired--;
        } else {
            daysRequired = 0;
        }
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();

        json.put("name",name);
        json.put("daysRequired",daysRequired);

        return json;
    }

    // getters

    public String getName() {
        return this.name;
    }

    public int getDaysRequired() {
        return this.daysRequired;
    }

}
