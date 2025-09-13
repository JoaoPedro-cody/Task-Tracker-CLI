package app;

import model.Task;
import model.TaskManager;

import java.io.File;

public class Program {
    public static void main(String[] args) {
        File file = new File("files/tasks.json");
        String cmd = args[0];

        TaskManager tm = new TaskManager();

        if (file.exists()){
            tm.loadTasks();
        }

        switch (cmd){
            case "add":
                String dsc = args[1];

                Task t = new Task(tm.newId(), dsc);

                System.out.println(tm.add(t));
                break;
            case "delete":
                String id = args[1];
                System.out.println(tm.delete(Integer.valueOf(id)));
                break;
            case "update":
                String id2 = args[1];
                String ndsc = args[2];
                System.out.println((tm.update(Integer.valueOf(id2), ndsc)));
                break;
        }

        tm.saveTasks();
    }
}
