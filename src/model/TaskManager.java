package model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private List<Task> list = new ArrayList<>();

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
                t.setUpdatedAt(LocalDateTime.now());
            }
        }
        return list;
    }
}
