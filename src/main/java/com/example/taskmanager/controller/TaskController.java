package com.example.taskmanager.controller;

import com.example.taskmanager.model.Task;
import com.example.taskmanager.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    // Affiche la liste des tâches
    @GetMapping
    public String listTasks(Model model) {
        model.addAttribute("tasks", service.findAll());
        return "list";
    }

    // Formulaire ajout
    @GetMapping("/add")
    public String showAddForm(Task task) {
        return "form";
    }

    // Formulaire modification
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Task task = service.findById(id).orElseThrow(() -> new IllegalArgumentException("ID Invalide:" + id));
        model.addAttribute("task", task);
        return "form";
    }

    // Sauvegarde (ajout/modification)
    @PostMapping("/save")
    public String saveTask(@Valid Task task, BindingResult result) {
        if (result.hasErrors()) {
            return "form";
        }
        service.save(task);
        return "redirect:/tasks";
    }

    // Suppression avec confirmation côté client
    @GetMapping("/delete/{id}")
    public String deleteTask(@PathVariable Long id) {
        service.deleteById(id);
        return "redirect:/tasks";
    }

    // Changer statut (simple toggle ici)
    @GetMapping("/status/{id}")
    public String toggleStatus(@PathVariable Long id) {
        Task task = service.findById(id).orElseThrow(() -> new IllegalArgumentException("ID Invalide:" + id));
        switch (task.getStatus()) {
            case A_REGARDER -> task.setStatus(Task.Status.EN_COURS);
            case EN_COURS -> task.setStatus(Task.Status.TERMINEE);
            case TERMINEE -> task.setStatus(Task.Status.A_REGARDER);
        }
        service.save(task);
        return "redirect:/tasks";
    }
}
