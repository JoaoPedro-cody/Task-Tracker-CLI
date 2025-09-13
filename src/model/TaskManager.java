package model;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private List<Task> list = new ArrayList<>();
    private static final String FILE_NAME = "files/tasks.json";

    Gson gs = new Gson();


    public TaskManager() {
    }


    public Integer newId(){
        Integer id = 1;
        for (Task t : list){
            while (t.getId().equals(id)){
                id++;
            }
        }
        return id;
    }

    public List<Task> add(Task t){
        list.add(t);
        return list;
    }

    public List<Task> delete(Integer id){
        list.removeIf(t -> t.getId().equals(id));
        return list;
    }

    public List<Task> update(Integer id, String s){
        for (Task t : list){
            if (id != null && id.equals(t.getId())){
                t.setDescription(s);
                t.setUpdatedAt(LocalDateTime.now().toString());
            }
        }
        return list;
    }

    public List<Task> markInProgress(Integer id){
        for (Task t: list){
            if (t.getId().equals(id)){
                t.setStatus("in-progress");
            }
        }
        return list;
    }

    public List<Task> markDone(Integer id){
        for (Task t: list){
            if (t.getId().equals(id)){
                t.setStatus("Done");
            }
        }
        return list;
    }

    public List<Task> listAll(){
        return list;
    }

    public List<Task> listDone(){
        List<Task> listDone = new ArrayList<>();
        for (Task t : list){
            if (t.getStatus().equals("Done")){
                listDone.add(t);
            }
        }
        return listDone;
    }

    public List<Task> listToDo(){
        List<Task> listToDo = new ArrayList<>();
        for (Task t : list){
            if (t.getStatus().equals("TODO")){
                listToDo.add(t);
            }
        }
        return listToDo;
    }

    public List<Task> listInProgress(){
        List<Task> listInProgress = new ArrayList<>();
        for (Task t : list){
            if (t.getStatus().equals("in-progress")){
                listInProgress.add(t);
            }
        }
        return listInProgress;
    }

    public void saveTasks(){

        if (list.isEmpty()) {
            File file = new File(FILE_NAME);
            if (file.exists()){
                file.delete();
            }
            return;
        }

        try (Writer writer = new FileWriter(FILE_NAME)){
            gs.toJson(list, writer);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void loadTasks(){
        try (Reader reader = new FileReader(FILE_NAME)){

            list = gs.fromJson(reader, new TypeToken<List<Task>>(){}.getType());
            if (list == null){
                list = new ArrayList<>();
            }
        } catch (FileNotFoundException e){
            list = new ArrayList<>();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
