package persistence;

import model.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;


import org.json.*;

public class JsonReader {
    private String source;

    public JsonReader(String source) { this.source = source; }

    public Game read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseGame(jsonObject);
    }

    public String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines( Paths.get(source), StandardCharsets.UTF_8)) {
             stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    public Game parseGame(JSONObject jsonObject) {
        String name = jsonObject.getString("projectName");
        int daysToFinishWork = (int) jsonObject.get("DaysToFinishWork");
        int eachDayAllowedTime = (int) jsonObject.get("EachDayAllowedTime");
        int currentDay = (int) jsonObject.get("currentDay");
        int currentTime = (int) jsonObject.get("currentTime");

        Game game = new Game(name, addStudents(jsonObject));
        game.setDaysToFinishWork(daysToFinishWork);
        game.setEachDayAllowedTime(eachDayAllowedTime);

        game.setCurrentDay(currentDay);
        game.setCurrentTime(currentTime);

        setAvailableLists(game);

        return game;
    }

    public void setAvailableLists(Game game) {
        //remake two lists about the personal tasks(up
        ArrayList<PersonalTask> cloneListOfPersonalTask = new ArrayList<>();
        ArrayList<String>       cloneAvailableActions   = new ArrayList<>();
        for (PersonalTask p : game.getListOfPersonalTask()) {
            if (p.getTimeRequiredToFinishTask() != 0) {
                cloneListOfPersonalTask.add(p);
                cloneAvailableActions.add(p.getName());
            }
        }
        //change original two lists to the new ones
        game.setListOfPersonalTask(cloneListOfPersonalTask);
        game.setActionsForPersonalTask(cloneAvailableActions);
    }

    public StudentList addStudents(JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("listOfStudents");
        StudentList stuList = new StudentList();
        for (Object json : jsonArray) {
            JSONObject nextStudent = (JSONObject) json;
            stuList.addStudent(addStudent(nextStudent));
        }
        return stuList;
    }

    public Student addStudent(JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        ArrayList<TeamTask> teamTask = addTeamTasks(jsonObject);
        ArrayList<PersonalTask> personalTask = addPersonalTasks(jsonObject);
        Student student = new Student(name, teamTask.get(0).getName() , teamTask.get(0).getDaysRequired(),
                personalTask.get(0).getName(), personalTask.get(0).getActionToFinishTask()
                , personalTask.get(0).getTimeRequiredToFinishTask());
        return student;
    }

    public ArrayList<TeamTask> addTeamTasks(JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("teamTask");
        ArrayList<TeamTask> teamTasks = new ArrayList<TeamTask>();
        for (Object json : jsonArray) {
            JSONObject nextTeamTask = (JSONObject) json;
            teamTasks.add(addTeamTask(nextTeamTask));
        }
        return teamTasks;
    }

    public TeamTask addTeamTask(JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        int daysRequired = (int) jsonObject.get("daysRequired");
        TeamTask teamTask = new TeamTask(name, daysRequired);
        return teamTask;
    }
    public ArrayList<PersonalTask> addPersonalTasks(JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("personalTasks");
        ArrayList<PersonalTask> personalTasks = new ArrayList<PersonalTask>();
        for (Object json : jsonArray) {
            JSONObject nextTeamTask = (JSONObject) json;
            personalTasks.add(addPersonalTask(nextTeamTask));
        }
        return personalTasks;
    }
    public PersonalTask addPersonalTask(JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        String actionToFinishTask = jsonObject.getString("actionToFinishTask");
        int timeRequiredToFinishTask = (int) jsonObject.get("timeRequiredToFinishTask");
        PersonalTask personalTask = new PersonalTask(name, actionToFinishTask , timeRequiredToFinishTask);
        return personalTask;
    }



}
