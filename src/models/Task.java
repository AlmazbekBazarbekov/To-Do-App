package models;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;

public class Task {
    private String taskName;
    private String taskDescription;
    private String taskCreateDateTime;
    private String taskDoneDateTime;
    private String taskPriority;
    private String taskStatus;

    public enum taskStatusEnum {
        NEW, IN_PROGRESS, DONE
    }


    public Task(String taskName, String taskDescription,  String taskPriority) {
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.taskCreateDateTime = setTaskLocalDate(LocalDateTime.now());
        this.taskDoneDateTime = null;
        this.taskPriority = taskPriority;
        this.taskStatus = taskStatusEnum.NEW.name();
    }



    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public LocalDateTime getTaskLocalDate() {
        return taskCreateDateTime != null ? LocalDateTime.parse(taskCreateDateTime) : null;
    }
    public String setTaskLocalDate(LocalDateTime taskLocalDate) {
       return this.taskCreateDateTime = taskLocalDate.toString();
    }

//    public String getTaskDoneDateTime() {
//        return taskDoneDateTime;
//    }

//    public void setTaskDoneDateTime(String taskDoneDateTime) {
//        this.taskDoneDateTime = taskDoneDateTime;
//    }

    public String getTaskPriority() {
        return taskPriority;
    }

    public void setTaskPriority(String taskPriority) {
        this.taskPriority = taskPriority;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }

    public void completeTask() {
        this.taskStatus = taskStatusEnum.DONE.name();
        this.taskDoneDateTime = setTaskLocalDate(LocalDateTime.now());
    }

    public void inProgressTask() {
        this.taskStatus = taskStatusEnum.IN_PROGRESS.name();
    }

    @Override
    public String toString() {
        return "Task [taskName= " + taskName + ", taskDescription= " + taskDescription + ", taskCreateDateTime= " + taskCreateDateTime;
    }
}
