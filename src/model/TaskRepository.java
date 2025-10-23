package model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class TaskRepository {
    private final Path FILE_PATH = Path.of("tasks.json");
    List<Task> tasks = new ArrayList<>();

    public void saveTasks(List<Task> tasks) {

        StringBuilder sb = new StringBuilder();
        sb.append("[\n");
        for (int i = 0; i < tasks.size(); i++){
            sb.append(tasks.get(i).toJson());
            if (i < tasks.size() - 1){
                sb.append(",\n");
            }
        }
        sb.append("\n]");

        String jsonResult = sb.toString();

        try {
            Files.writeString(FILE_PATH, jsonResult);
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    public List<Task> loadTasks() throws IOException {

        String jsonContent = Files.readString(FILE_PATH);

        // divide os objetos pelo padrão "},"
        String[] taskList = jsonContent
                .replace("[", "")
                .replace("]", "")
                .split("},");

        for (String taskJson : taskList) {
            taskJson = taskJson.trim();
            if (!taskJson.endsWith("}")) {
                taskJson = taskJson + "}";
            }
            tasks.add(Task.fromJson(taskJson));
        }

        return tasks;
    }
}
