package model;

public class TeamTask {
    private String name;
    private int    daysRequired;

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
}
