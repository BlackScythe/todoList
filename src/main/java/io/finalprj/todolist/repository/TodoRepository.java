package io.finalprj.todolist.repository;

import io.finalprj.todolist.entity.TodoItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<TodoItem, Long> {
    public List<TodoItem> findByStatus(Boolean status);

    public List<TodoItem> findByTodo(String todo);
    
    public List<TodoItem> findByTodoAndStatus(String todo, Boolean status);

    public List<TodoItem> findByUserId(Long userId);
}
