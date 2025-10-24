package app;

import model.Task;
import model.TaskManager;
import model.TaskRepository;

import java.io.File;
import java.io.IOException;

public class Program {
    public static void main(String[] args) throws IOException {
        File file = new File("tasks.json");
        String cmd = args[0];
        TaskManager tm = new TaskManager();
        TaskRepository tr = new TaskRepository();

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
                System.out.println("Task deleted successfully (ID: " + deleteId + ")");
                break;
            case "update":
                String updateId = args[1];
                String newDescription = args[2];
                tm.update(Integer.valueOf(updateId), newDescription);
                System.out.println("Task updated successfully (ID: " + updateId + ")");
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
                    tm.listAll().forEach(System.out::println);
                }else {
                    String listType = args[1];
                    switch (listType){
                        case "done":
                            tm.listDone().forEach(System.out::println);
                            break;
                        case "in-progress":
                            tm.listInProgress().forEach(System.out::println);
                            break;
                        case "todo":
                            tm.listToDo().forEach(System.out::println);
                            break;
                    }
                }
        }

        tr.saveTasks(tm.getList());
    }
}
