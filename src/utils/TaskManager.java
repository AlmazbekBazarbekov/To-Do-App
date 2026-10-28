package utils;

import models.Task;

import java.util.List;
import java.util.Scanner;

public class TaskManager {
    private List<Task> tasks;

    public TaskManager() {}

    public TaskManager(List<Task> tasks) {
        this.tasks = tasks;
    }

    public List<Task> getTasks() {
        return tasks;
    }


    public static void createNewTasks(List<Task> tasks) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя новой задачи: ");
        String name = scanner.nextLine();
        System.out.println("Введите описание задачи: ");
        String description = scanner.nextLine();
        System.out.println("Задайте приоритет задаче - LOW - MIDDLE - HIGH ");
        String priority = scanner.nextLine();

        tasks.add(new Task(name, description, priority));
    }

    public static void deleteTask(List<Task> tasks) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите название задачи которую хотите удалить");
        String taskName = scanner.nextLine();

        var task = tasks
                .stream()
                .filter(t -> t.getTaskName().equals(taskName))
                .findFirst()
                .get();

        if (task.getTaskStatus().equals("NEW")) {
            tasks.remove(task);
        }
        else{
            System.out.println("Вы не можете удалять задачи со статусами кроме NEW!");
        }
    }

    public static void printTasks(List<Task> tasks) {
        tasks.forEach(System.out::println);
    }



}
