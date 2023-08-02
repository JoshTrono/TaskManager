package com.JoshuaTrono.TaskManager.controller;

import com.JoshuaTrono.TaskManager.DTO.TaskDTO;
import com.JoshuaTrono.TaskManager.entity.Task;
import com.JoshuaTrono.TaskManager.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.List;

@RestController
@RequestMapping("/api/v1/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;
    @PostMapping
    @CacheEvict(value = "tasks", allEntries = true)
    public Task createTask(@RequestBody TaskDTO task) {
        return taskService.createTask(task);
    }
    @GetMapping
    @Cacheable("tasks")
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/{id}")
    @Cacheable(value = "tasks", key = "#id")
    public Task getTaskById(@PathVariable long id) {
        return taskService.getTaskById(id);
    }

    @PutMapping("/{id}")
    @CachePut(value = "tasks", key = "#id")
    public Task updateTask(@PathVariable long id, @RequestBody TaskDTO task) {
        return taskService.updateTask(id, task);
    }
    @PatchMapping("/{id}")
    @CachePut(value = "tasks", key = "#id")
    public Task updateTaskStatus(@PathVariable long id, @RequestBody TaskDTO task) {
        return taskService.updatePatchTask(id, task);
    }
    @DeleteMapping("/{id}")
    @CacheEvict(value = "tasks", key = "#id")
    public void deleteTask(@PathVariable long id) {
        taskService.deleteTask(id);
    }
}
