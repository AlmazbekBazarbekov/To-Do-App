package utils;

import models.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.util.Comparator.comparing;

public class TaskManager {
    private List<Task> tasks;

    public TaskManager(List<Task> tasks) {
        this.tasks = tasks;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public enum sortCriteria {
        BY_DATE, BY_PRIORITY
    }


    public void createNewTasks(String name, String description, String priority) {
        tasks.add(new Task(name, description, priority));
    }

    public void deleteTask(String taskName) {
        var task = tasks
                .stream()
                .filter(t -> t.getTaskName().equalsIgnoreCase(taskName))
                .findFirst()
                .orElse(null);

        if (task == null) {
            System.out.println("Задача с таким названием не существует");
        }
        else if (task.getTaskStatus().equals("NEW")) {
            tasks.remove(task);
            System.out.println("Задача была успешно удалена!");
        }
        else{
            System.out.println("Вы не можете удалять задачи со статусами кроме NEW!");
        }
    }

    public List<Task> sortedTasks(sortCriteria criteria) {
        List<Task> sortedTasks = new ArrayList<>();
         switch (criteria){
            case BY_DATE:
                   sortedTasks = tasks
                        .stream()
                        .sorted(comparing(Task::getTaskLocalDate).reversed())
                        .toList();
                break;

            case BY_PRIORITY:
                    sortedTasks = tasks
                        .stream()
                        .sorted(comparing(Task::getTaskPriority))
                        .toList();
        }
        return sortedTasks;
    }

    public void ChangeTasksDescription (String taskName) {
        Scanner scanner = new Scanner(System.in);

        var task = tasks
                .stream()
                .filter(t -> t.getTaskName().equalsIgnoreCase(taskName))
                .findFirst()
                .orElse(null);
        if (task == null) {
            System.out.println("Задача с таким названием не существует");
        } else {
            System.out.println("Введите новое описание");
            task.setTaskDescription(scanner.nextLine());
        }
    }

    public void printTasks() {
        tasks.forEach(System.out::println);
    }

    public void printTasks(List<Task> tasks) {
        tasks.forEach(System.out::println);
    }



}
