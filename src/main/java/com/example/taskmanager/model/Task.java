package com.example.taskmanager.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;

    @Enumerated(EnumType.STRING)
    private Priority priority;

    @Enumerated(EnumType.STRING)
    private Status status = Status.A_REGARDER;

    private LocalDate dueDate;

    // Getters et Setters

    public enum Priority {
        URGENTE, NORMALE, FAIBLE
    }

    public enum Status {
        A_REGARDER, EN_COURS, TERMINEE
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) { this.id = id; }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) { this.title = title; }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) { this.description = description; }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) { this.priority = priority; }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) { this.status = status; }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) { this.dueDate = dueDate; }
}
