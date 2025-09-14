package model;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private List<Task> list = new ArrayList<>();

    public TaskManager() {
    }

    public List<Task> getList() {
        return list;
    }

    public void setList(List<Task> list) {
        this.list = list;
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

    public void add(Task t){
        list.add(t);
    }

    public void delete(Integer id){
        list.removeIf(t -> t.getId().equals(id));
    }

    public void update(Integer id, String s){
        for (Task t : list){
            if (id != null && id.equals(t.getId())){
                t.setDescription(s);
                t.setUpdatedAt(LocalDateTime.now().toString());
            }
        }
    }

    public void markInProgress(Integer id){
        for (Task t: list){
            if (t.getId().equals(id)){
                t.setStatus("In-progress");
            }
        }
    }

    public void markDone(Integer id){
        for (Task t: list){
            if (t.getId().equals(id)){
                t.setStatus("Done");
            }
        }
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
            if (t.getStatus().equals("Todo")){
                listToDo.add(t);
            }
        }
        return listToDo;
    }

    public List<Task> listInProgress(){
        List<Task> listInProgress = new ArrayList<>();
        for (Task t : list){
            if (t.getStatus().equals("In-progress")){
                listInProgress.add(t);
            }
        }
        return listInProgress;
    }
}
