package net.furikuri.repository;

import net.furikuri.domain.Todo;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
//@Profile("mock")
public class ImMemoryTodoRepository implements TodoRepository {

  private List<Todo> todos = new ArrayList<>();

  @Override
  public void save(Todo todo) {
    todos.add(todo);
  }

  @Override
  public List<Todo> findAll() {
    return todos;
  }
}
