package model;

public class PersonalTask {
    private String name;
    private String actionToFinishTask;

    public PersonalTask(String taskname, String action) {
        name = taskname;
        actionToFinishTask = action;
    }

    public String getName() {
        return this.name;
    }

    public String getActionToFinishTask() {
        return this.actionToFinishTask;
    }
}
