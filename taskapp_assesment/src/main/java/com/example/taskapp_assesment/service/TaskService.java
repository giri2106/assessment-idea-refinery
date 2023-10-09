package com.example.taskapp_assesment.service;

import com.example.taskapp_assesment.model.Task;

import java.util.List;

public interface TaskService {
    List<Task> getAllTasks();
    String createTask(Task taskRequest);
    Task getTaskById(Integer id);

    String updateTask(Integer id, Task taskRequest);
}
