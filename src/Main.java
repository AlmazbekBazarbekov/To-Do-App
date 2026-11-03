import models.Task;
import utils.TaskCollection;
import utils.TaskManager;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        List<Task> tasks = TaskCollection.TaskCollectionRead("data/tasks.json");
        TaskManager taskManager = new TaskManager(tasks);

        taskManager.printTasks();

        int choice;

        do {
            System.out.println("==Введите действие которохо хотите сделать с задачей==\n 1. Создать новую задачу \n 2. Удалить задачу \n 3. Отсортировать список по дате и вывести на экран \n 4. Изменить описание задачи \n 5. Завершить и выйти ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                        System.out.println("Введите имя новой задачи: ");
                        String name = scanner.nextLine();
                        System.out.println("Введите описание задачи: ");
                        String description = scanner.nextLine();
                        System.out.println("Задайте приоритет задаче - LOW - MIDDLE - HIGH ");
                        String priority = scanner.nextLine();
                        taskManager.createNewTasks(name, description, priority);

                    break;
                case 2:
                    System.out.println("Введите название задачи которую хотите удалить");
                    String taskName = scanner.nextLine();

                    taskManager.deleteTask(taskName);

                    break;

                case 3:
                    TaskManager.sortCriteria sort = TaskManager.sortCriteria.BY_DATE;
                    taskManager.sortedTasks(sort);

                    break;

                case 4:
                    System.out.println("Введите название задачи описание которой хотите изменить: ");
                    String task = scanner.nextLine();

                    taskManager.ChangeTasksDescription(task);

                    break;
            }

        } while (choice != 5);

        TaskCollection.TaskCollectionWrite("data/tasks.json", taskManager.getTasks());
    }
}
