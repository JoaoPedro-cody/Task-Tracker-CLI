package app;

import model.Task;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Task task = new Task(1, "Complete Project", "TODO",LocalDateTime.now(), LocalDateTime.now() );
        System.out.println(task);



    }
}
