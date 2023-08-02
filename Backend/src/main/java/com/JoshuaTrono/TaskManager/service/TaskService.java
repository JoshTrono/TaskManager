package com.JoshuaTrono.TaskManager.service;

import com.JoshuaTrono.TaskManager.DTO.TaskDTO;
import com.JoshuaTrono.TaskManager.entity.Task;
import com.JoshuaTrono.TaskManager.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    private final TaskRepository taskRepository;
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }


    public Task createTask(TaskDTO task) {
        Task newTask = new Task();
        newTask.setName(task.getName());
        newTask.setDescription(task.getDescription());
        newTask.setStatus(task.getStatus());
        newTask.setDueDate(task.getDueDate());
        newTask.setPriority(task.getPriority());
        newTask.setCategory(task.getCategory());
        return taskRepository.save(newTask);
    }

    public List<Task> getAllTasks() {
        return (List<Task>) taskRepository.findAll();
    }

    public Task updateTask(long id, TaskDTO task) {
        Task updatedTask = taskRepository.findById(id).orElseThrow();
        updatedTask.setName(task.getName());
        updatedTask.setDescription(task.getDescription());
        updatedTask.setStatus(task.getStatus());
        updatedTask.setDueDate(task.getDueDate());
        updatedTask.setPriority(task.getPriority());
        updatedTask.setCategory(task.getCategory());
        return taskRepository.save(updatedTask);
    }

    public Task getTaskById(long id) {
        return taskRepository.findById(id).orElseThrow();
    }

    public void deleteTask(long id) {
        taskRepository.deleteById(id);
    }

    public Task updatePatchTask(long id, TaskDTO task) {
        Task updatedTask = taskRepository.findById(id).orElseThrow();
        if (task.getName() != null) {
            updatedTask.setName(task.getName());
        }
        if (task.getDescription() != null) {
            updatedTask.setDescription(task.getDescription());
        }
        if (task.getStatus() != null) {
            updatedTask.setStatus(task.getStatus());
        }
        if (task.getDueDate() != null) {
            updatedTask.setDueDate(task.getDueDate());
        }
        if (task.getPriority() != null) {
            updatedTask.setPriority(task.getPriority());
        }
        if (task.getCategory() != null) {
            updatedTask.setCategory(task.getCategory());
        }
        return taskRepository.save(updatedTask);
    }
}
