package net.furikuri.repository;

import net.furikuri.domain.Todo;

import java.util.List;

public interface TodoRepository {
  void save(Todo todo);

  List<Todo> findAll();
}
