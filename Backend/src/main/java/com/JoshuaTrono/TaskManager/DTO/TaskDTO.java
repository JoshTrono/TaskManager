package com.JoshuaTrono.TaskManager.DTO;

import lombok.Data;

@Data
public class TaskDTO {
    //private long id;
    private String name;
    private String description;
    private String status;
    private String dueDate;
    private String priority;
    private String category;
}
