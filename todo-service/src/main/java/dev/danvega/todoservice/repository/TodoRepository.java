package dev.danvega.todoservice.repository;

import dev.danvega.todoservice.model.Todo;
import org.springframework.data.repository.ListCrudRepository;

public interface TodoRepository extends ListCrudRepository<Todo,Integer> {

}
