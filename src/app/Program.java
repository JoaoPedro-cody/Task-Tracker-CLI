package app;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.Task;
import model.TaskManager;

import java.io.File;

public class Program {
    public static void main(String[] args) {
        File file = new File("files/tasks.json");
        String cmd = args[0];
        TaskManager tm = new TaskManager();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        if (file.exists()){
            tm.loadTasks();
        }

        switch (cmd){
            case "add":
                String dsc = args[1];
                Task t = new Task(tm.newId(), dsc);
                tm.add(t);
                break;
            case "delete":
                String id = args[1];
                tm.delete(Integer.valueOf(id));
                break;
            case "update":
                String id2 = args[1];
                String ndsc = args[2];
                tm.update(Integer.valueOf(id2), ndsc);
                break;
            case "mark-in-progress":
                String id3 = args[1];
                tm.markInProgress(Integer.valueOf(id3));
                break;
            case "mark-done":
                String id4 = args[1];
                tm.markDone(Integer.valueOf(id4));
                break;
            case  "list":
                if (args.length < 2){
                    System.out.println(gson.toJson(tm.listAll()));
                }else {
                    String cmd2 = args[1];
                    switch (cmd2){
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

        tm.saveTasks();
    }
}
