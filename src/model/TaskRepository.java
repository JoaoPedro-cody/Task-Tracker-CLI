package model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TaskRepository {
    private static final String FILE_NAME = "tasks.json";
    List<Task> tasks = new ArrayList<>();
    Gson gs = new GsonBuilder().setPrettyPrinting().create();

    public void saveTasks(List<Task> t) {

        if (t.isEmpty()) {
            File file = new File(FILE_NAME);
            if (file.exists()){
                file.delete();
            }
            return;
        }

        try (Writer writer = new FileWriter(FILE_NAME)){
            gs.toJson(t, writer);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public List<Task> loadTasks(){
        try (Reader reader = new FileReader(FILE_NAME)){

            tasks = gs.fromJson(reader, new TypeToken<List<Task>>(){}.getType());
            if (tasks == null){
                tasks = new ArrayList<>();
            }
        } catch (FileNotFoundException e){
            tasks = new ArrayList<>();
        } catch (IOException e){
            e.printStackTrace();
        }
        return tasks;
    }
}
