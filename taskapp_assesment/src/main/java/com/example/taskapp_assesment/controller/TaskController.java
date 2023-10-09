package com.example.taskapp_assesment.controller;

import com.example.taskapp_assesment.exception.TaskNotFoundException;
import com.example.taskapp_assesment.model.Task;
import com.example.taskapp_assesment.serviceImpl.TaskServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController{

    @Autowired
    private TaskServiceImpl taskServiceImpl;

    @GetMapping("")
    public ResponseEntity<List<Task>> getAllTasks(){
        return new ResponseEntity<>(taskServiceImpl.getAllTasks(), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<String> createTask(@RequestBody Task taskRequest){
        return new ResponseEntity<>(taskServiceImpl.createTask(taskRequest), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTasksById(@PathVariable Integer id) throws TaskNotFoundException {
        return new ResponseEntity<>(taskServiceImpl.getTaskById(id),HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<String> update(@PathVariable Integer id, @RequestBody Task taskRequest){
        return new ResponseEntity<>(taskServiceImpl.updateTask(id, taskRequest), HttpStatus.OK);
    }


}