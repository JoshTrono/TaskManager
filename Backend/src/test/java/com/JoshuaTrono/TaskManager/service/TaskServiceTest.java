package com.JoshuaTrono.TaskManager.service;

import com.JoshuaTrono.TaskManager.DTO.TaskDTO;
import com.JoshuaTrono.TaskManager.entity.Task;
import com.JoshuaTrono.TaskManager.repository.TaskRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class TaskServiceTest {
    @Mock
    private TaskRepository taskRepository;

    private TaskService taskService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        taskService = new TaskService(taskRepository);
    }

    @Test
    void createTask_shouldCreateNewTask() {
        // Arrange
        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setName("Test Task");
        taskDTO.setDescription("Test Description");
        taskDTO.setStatus("Pending");
        taskDTO.setDueDate("2023-07-13");
        taskDTO.setPriority("High");
        taskDTO.setCategory("Test");

        Task task = new Task();
        task.setName("Test Task");
        task.setDescription("Test Description");
        task.setStatus("Pending");
        task.setDueDate("2023-07-13");
        task.setPriority("High");
        task.setCategory("Test");

        when(taskRepository.save(any(Task.class))).thenReturn(task);

        // Act
        Task createdTask = taskService.createTask(taskDTO);

        // Assert
        assertEquals("Test Task", createdTask.getName());
        assertEquals("Test Description", createdTask.getDescription());
        assertEquals("Pending", createdTask.getStatus());
        assertEquals("2023-07-13", createdTask.getDueDate());
        assertEquals("High", createdTask.getPriority());
        assertEquals("Test", createdTask.getCategory());

        verify(taskRepository, times(1)).save(any(Task.class));
    }

    @Test
    void getAllTasks_shouldReturnAllTasks() {
        // Arrange
        Task task1 = new Task();
        task1.setId(1L);
        task1.setName("Task 1");

        Task task2 = new Task();
        task2.setId(2L);
        task2.setName("Task 2");

        when(taskRepository.findAll()).thenReturn(Arrays.asList(task1, task2));

        // Act
        List<Task> tasks = taskService.getAllTasks();

        // Assert
        assertEquals(2, tasks.size());
        assertEquals("Task 1", tasks.get(0).getName());
        assertEquals("Task 2", tasks.get(1).getName());

        verify(taskRepository, times(1)).findAll();
    }

    @Test
    public void testPatchTask() {
        // Arrange
        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setName("Test Change");
        taskDTO.setDescription("Test Description");
        taskDTO.setStatus("Pending");
        taskDTO.setDueDate("2023-07-13");
        taskDTO.setPriority("High");
        taskDTO.setCategory("Test");

        Task task = new Task();
        task.setId(1L);
        task.setName("Test Task");
        task.setDescription("Test Description");
        task.setStatus("Pending");
        task.setDueDate("2023-07-13");
        task.setPriority("High");
        task.setCategory("Test");

        when(taskRepository.findById(anyLong())).thenReturn(Optional.of(task));
        when(taskRepository.save(any(Task.class))).thenReturn(task);

        // Act
        Task updatedTask = taskService.updatePatchTask(1L, taskDTO);

        // Assert
        assertEquals("Test Change", updatedTask.getName());
        assertEquals("Test Description", updatedTask.getDescription());
        assertEquals("Pending", updatedTask.getStatus());
        assertEquals("2023-07-13", updatedTask.getDueDate());
        assertEquals("High", updatedTask.getPriority());
        assertEquals("Test", updatedTask.getCategory());
    }

    // Add more test methods for other TaskService functionalities (updateTask, getTaskById, deleteTask)
}
