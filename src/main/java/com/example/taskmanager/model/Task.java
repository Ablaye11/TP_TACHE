package com.example.taskmanager.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Entity
@Table(name = "tache")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Le titre est obligatoire")
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    @NotNull(message = "La priorité est obligatoire")
    @Enumerated(EnumType.STRING)
    private Priority priorite;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Status status = Status.A_REGARDER;

    private LocalDate dueDate;

    // Getters et setters

    public enum Priority {
        URGENTE, NORMALE, FAIBLE
    }

    public enum Status {
        A_REGARDER, EN_COURS, TERMINEE;

        public String getDisplayName() {
            return this.name().replace('_', ' ');
        }
    }

    // ... getters et setters ...

    // Exemple getter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // (Ajoute tous les autres getters/setters de façon similaire)

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Priority getPriorite() {
        return priorite;
    }

    public void setPriorite(Priority priorite) {
        this.priorite = priorite;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }
    public String getFormattedStatus() {
        return status.name().replace('_', ' ');
    }
}
