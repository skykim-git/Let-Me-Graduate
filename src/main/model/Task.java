package model;

import org.json.JSONObject;
import persistence.Writable;

public abstract class Task implements Writable {
    protected String name;
    protected int timeRequired;

    public Task(String name, int time) {
        this.name = name;
        this.timeRequired = time;
    }

    public String getName() {
        return this.name;
    }

    public int getTimeRequired() {
        return this.timeRequired;
    }

    @Override
    public abstract JSONObject toJson();
}
