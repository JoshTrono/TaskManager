package com.JoshuaTrono.TaskManager.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Task {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String description;
    private String status;
    private String dueDate;
    private String priority;
    private String category;

}
