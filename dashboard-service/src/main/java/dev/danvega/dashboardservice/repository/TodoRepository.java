package dev.danvega.dashboardservice.repository;

import dev.danvega.dashboardservice.model.Todo;
import org.springframework.data.repository.ListCrudRepository;

public interface TodoRepository extends ListCrudRepository<Todo,Integer> {

}
