package app;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.Task;
import model.TaskManager;
import model.TaskRepository;

import java.io.File;

public class Program {
    public static void main(String[] args) {
        File file = new File("tasks.json");
        String cmd = args[0];
        TaskManager tm = new TaskManager();
        TaskRepository tr = new TaskRepository();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        if (file.exists()){
            tm.setList(tr.loadTasks());
        }

        switch (cmd){
            case "add":
                String taskDescription = args[1];
                Task t = new Task(tm.newId(), taskDescription);
                tm.add(t);
                System.out.println("Task added successfully (ID: " + t.getId() + ")");
                break;
            case "delete":
                String deleteId = args[1];
                tm.delete(Integer.valueOf(deleteId));
                break;
            case "update":
                String updateId = args[1];
                String newDescription = args[2];
                tm.update(Integer.valueOf(updateId), newDescription);
                break;
            case "mark-in-progress":
                String inProgressId = args[1];
                tm.markInProgress(Integer.valueOf(inProgressId));
                break;
            case "mark-done":
                String doneId = args[1];
                tm.markDone(Integer.valueOf(doneId));
                break;
            case  "list":
                if (args.length < 2){
                    System.out.println(gson.toJson(tm.listAll()));
                }else {
                    String listType = args[1];
                    switch (listType){
                        case "done":
                            System.out.println(gson.toJson(tm.listDone()));
                            break;
                        case "in-progress":
                            System.out.println(gson.toJson(tm.listInProgress()));
                            break;
                        case "todo":
                            System.out.println(gson.toJson(tm.listToDo()));
                            break;
                    }
                }
        }

        tr.saveTasks(tm.getList());
    }
}
