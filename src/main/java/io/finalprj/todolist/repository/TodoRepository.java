package io.finalprj.todolist.repository;

import io.finalprj.todolist.entity.TodoItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface TodoRepository extends CrudRepository<TodoItem, Long> {
    public Iterable<TodoItem> findByStatus(Boolean status);
}
