package dev.danvega.todoservice.controller;

import dev.danvega.todoservice.model.Todo;
import dev.danvega.todoservice.service.TodoService;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

    private final TodoService todoService;
    private final RestTemplate restTemplate;

    public TodoController(TodoService todoService, RestTemplate restTemplate) {
        this.todoService = todoService;
        this.restTemplate = restTemplate;
    }

    @GetMapping
    public List<Todo> findAll() {
        return todoService.findAll();
    }

}
