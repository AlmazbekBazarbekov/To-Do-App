package utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import models.Task;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class TaskCollection {
    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static List<Task> TaskCollectionRead(String fileName) throws IOException {
        Path path = Paths.get(fileName);
        String read = Files.readString(path);
        Type listType = new TypeToken<List<Task>>(){}.getType();

        List<Task> tasks = gson.fromJson(read, listType);

        return tasks != null ? tasks : new ArrayList<>();
    }

    public static void TaskCollectionWrite(String fileName, List<Task> tasks) throws IOException {
        Path path = Paths.get(fileName);
        String write = gson.toJson(tasks);
        byte[] bytes = write.getBytes();
        Files.write(path, bytes);
    }
}
