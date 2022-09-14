package dev.danvega.todoservice.service;

import dev.danvega.todoservice.model.Todo;
import dev.danvega.todoservice.repository.TodoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class TodoService {

    private static final Logger LOG = LoggerFactory.getLogger(TodoService.class);
    private final String DASHBOARD_API_URL = "http://localhost:8081/api/dashboard/todos";
    private final TodoRepository repository;
    private final RestTemplate restTemplate;

    public TodoService(TodoRepository repository, RestTemplate restTemplate) {
        this.repository = repository;
        this.restTemplate = restTemplate;
    }

    public List<Todo> findAll() {
        return repository.findAll();
    }

    public void saveAll(List<Todo> todos) {
        repository.saveAll(todos);
    }

    public void sendToDashboard(List<Todo> todos) {
        ResponseEntity<String> response = restTemplate.postForEntity(DASHBOARD_API_URL, todos, String.class);
        if( response.getStatusCode().is2xxSuccessful()) {
            LOG.info("Todos sent to dashboard successfully!");
        }
    }

}
