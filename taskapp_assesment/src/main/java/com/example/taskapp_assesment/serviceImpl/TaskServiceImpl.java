package com.example.taskapp_assesment.serviceImpl;


import com.example.taskapp_assesment.exception.TaskNotFoundException;
import com.example.taskapp_assesment.model.Task;
import com.example.taskapp_assesment.service.TaskService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TaskServiceImpl implements TaskService {

    static Map<Integer, Task> taskMap = new HashMap<>();

    @Override
    public List<Task> getAllTasks() {
        List<Task> taskList = new ArrayList<>(taskMap.values());
        return taskList;
    }

    @Override
    public String createTask(Task taskRequest) {
        taskRequest.setId(taskMap.size()+1);
        taskMap.put(taskMap.size()+1 , taskRequest);
        return "task created successfully";
    }

    @Override
    public Task getTaskById(Integer id) {
        if(taskMap.containsKey(id)) return taskMap.get(id);
        throw new TaskNotFoundException("Task not found");
    }

    @Override
    public String updateTask(Integer id, Task taskRequest) {
        if(!taskMap.containsKey(id)) throw new TaskNotFoundException("Task not found");
        Task task = taskMap.get(id);

        if(taskRequest.getTitle() != null) task.setTitle(taskRequest.getTitle());
        if(taskRequest.getDescription() != null) task.setDescription(taskRequest.getDescription());
        if(taskRequest.getCompleteDate() != null) task.setCompleteDate(taskRequest.getCompleteDate());
        if(taskRequest.getCreateDate() != null) task.setCreateDate(taskRequest.getCreateDate());
        if(taskRequest.getCompleted() != null) task.setCompleted(taskRequest.getCompleted());

//        taskMap.put(id, task);

        return "task updated successfully";
    }


}