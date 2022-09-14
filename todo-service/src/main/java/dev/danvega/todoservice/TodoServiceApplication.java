package dev.danvega.todoservice;

import dev.danvega.todoservice.model.Todo;
import dev.danvega.todoservice.repository.TodoRepository;
import dev.danvega.todoservice.service.JsonPlaceHolderService;
import dev.danvega.todoservice.service.TodoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@SpringBootApplication
public class TodoServiceApplication {

	private static final Logger log = LoggerFactory.getLogger(TodoServiceApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(TodoServiceApplication.class, args);
	}

	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Bean
	CommandLineRunner commandLineRunner(JsonPlaceHolderService placeHolderService, TodoService todoService) {
		return args -> {
			// when the application loads get the 200 todos from JsonPlaceholder
			List<Todo> todos = placeHolderService.getTodos();
			todoService.saveAll(todos);
			log.info("Saved {} todos in the database", todos.size());

			// when we are done saving these send them off to our dashboard
			todoService.sendToDashboard(todos);
		};
	}
}
