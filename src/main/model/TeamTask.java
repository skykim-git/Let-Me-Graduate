package model;

public class TeamTask {
    private String name;
    private int    daysRequired;

    public TeamTask(String taskname, int days) {
        name = taskname;
        daysRequired = days;
    }

    public String getName() {
        return this.name;
    }

    public int getDaysRequired() {
        return this.daysRequired;
    }
}
