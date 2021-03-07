package model;

import org.json.JSONObject;
import persistence.Writable;

public class TeamTask implements Writable {
    private String name;
    private int daysRequired;

    public TeamTask(String taskName, int days) {
        name = taskName;
        daysRequired = days;
    }

    public String getName() {
        return this.name;
    }

    public int getDaysRequired() {
        return this.daysRequired;
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

}
