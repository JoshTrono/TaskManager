package com.JoshuaTrono.TaskManager.controller;

import com.JoshuaTrono.TaskManager.DTO.TaskDTO;
import com.JoshuaTrono.TaskManager.entity.Task;
import com.JoshuaTrono.TaskManager.repository.TaskRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TaskContollerTest {

    @Autowired
    private TaskController taskController;

    @MockBean
    private TaskRepository taskRepository;

    @Test
    public void testCreateTask() {
        // Arrange
        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setName("Test Task");
        taskDTO.setDescription("This is a test task.");
        taskDTO.setStatus("In Progress");
        taskDTO.setDueDate("2021-04-30");
        taskDTO.setPriority("High");
        taskDTO.setCategory("Test");

        Task savedTask = new Task();
        savedTask.setId(1L);
        savedTask.setName(taskDTO.getName());
        savedTask.setDescription(taskDTO.getDescription());
        savedTask.setStatus(taskDTO.getStatus());

        Mockito.when(taskRepository.save(Mockito.any(Task.class))).thenReturn(savedTask);

        // Act
        Task response = taskController.createTask(taskDTO);

        // Assert
        assertNotNull(response.getId());
        assertEquals(response.getName(), taskDTO.getName());
        assertEquals(response.getDescription(), taskDTO.getDescription());
        assertEquals(response.getStatus(), taskDTO.getStatus());
    }
}

