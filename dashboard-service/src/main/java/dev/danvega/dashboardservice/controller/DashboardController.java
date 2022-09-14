package dev.danvega.dashboardservice.controller;

import dev.danvega.dashboardservice.model.Todo;
import dev.danvega.dashboardservice.repository.TodoRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {

    private final TodoRepository repository;

    public DashboardController(TodoRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/todos")
    public void loadTodos(@RequestBody List<Todo> todos) {
        repository.saveAll(todos);
    }

}
