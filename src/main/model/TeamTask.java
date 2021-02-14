package model;

public class TeamTask {
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
}
