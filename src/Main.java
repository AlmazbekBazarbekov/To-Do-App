import models.Task;
import utils.TaskCollection;
import utils.TaskManager;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<Task> tasks = TaskCollection.TaskCollectionRead("data/tasks.json");

        System.out.println(tasks);

//        TaskManager.createNewTasks(tasks);
//
//        TaskManager.printTasks(tasks);

        TaskManager.deleteTask(tasks);
//
//        TaskManager.printTasks(tasks);

        TaskCollection.TaskCollectionWrite("data/tasks.json", tasks);
    }
}
