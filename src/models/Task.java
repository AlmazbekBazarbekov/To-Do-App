package models;

import java.time.ZonedDateTime;

public class Task {
    private String taskName;
    private String taskDescription;
    private ZonedDateTime taskCreateDateTime;
//    private String taskDoneDateTime;
    private String taskPriority;
    private String taskStatus;


    public Task(String taskName, String taskDescription,  String taskPriority) {
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.taskCreateDateTime = ZonedDateTime.now();
//        this.taskDoneDateTime = taskDoneDateTime;
        this.taskPriority = taskPriority;
        this.taskStatus = "NEW";
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

    public ZonedDateTime getTaskCreateDateTime() {
        return taskCreateDateTime;
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

    @Override
    public String toString() {
        return "Task [taskName=" + taskName + ", taskDescription=" + taskDescription + ", taskCreateDateTime=" + taskCreateDateTime;
    }
}
