package model;

public class PersonalTask {
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

    public int getTimeRequiredToFinishTask() { return this.timeRequiredToFinishTask;}
}
