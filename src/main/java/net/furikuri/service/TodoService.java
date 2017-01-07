package net.furikuri.service;

import net.furikuri.domain.Todo;
import net.furikuri.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TodoService {

  @Autowired
  private TodoRepository repository;

  public void add(Todo todo) {
    todo.setId(UUID.randomUUID().toString());
    repository.save(todo);
  }

  public List<Todo> all() {
    return repository.findAll();
  }

}
