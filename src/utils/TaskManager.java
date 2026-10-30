package utils;

import models.Task;

import java.util.List;
import java.util.Scanner;

import static java.util.Comparator.comparing;

public class TaskManager {
    private List<Task> tasks;

    public TaskManager() {}

    public TaskManager(List<Task> tasks) {
        this.tasks = tasks;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    private enum sortCriteria {
        BY_DATE, BY_PRIORITY
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

    public static List<Task> sortedTasks(List<Task> tasks, sortCriteria criteria) {
        switch (criteria){
            case BY_DATE:
                tasks
                        .stream()
                        .sorted(comparing(Task::getTaskLocalDate))
                        .toList();
                break;

            case BY_PRIORITY:
                tasks
                        .stream()
                        .sorted(comparing(Task::getTaskPriority))
                        .toList();
        }
        return tasks;
    }

    public static void printTasks(List<Task> tasks) {
        tasks.forEach(System.out::println);
    }



}
