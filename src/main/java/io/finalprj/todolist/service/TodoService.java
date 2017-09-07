package io.finalprj.todolist.service;

import io.finalprj.todolist.entity.TodoItem;
import io.finalprj.todolist.repository.TodoRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    private static final Logger logger = Logger.getLogger(TodoService.class);

    public Iterable<TodoItem> getTodos() {
        logger.info("Getting all Todos");
        return todoRepository.findAll();
    }

    public Iterable<TodoItem> getStatusTodos(Boolean status) {
        logger.info("Getting all Todos where status is: " + status);
        return todoRepository.findByStatus(status);
    }

    public TodoItem getTodo(Long id) {
        logger.info("Getting todo: " + id);
        return todoRepository.findOne(id);
    }

    public Iterable<TodoItem> getTodo(String todo){
        logger.info("Getting todos: " + todo);
        List<TodoItem> todos = (List<TodoItem>) todoRepository.findAll();
        // this could be a simple: return todoRepository.findByStatus(todo), but streams were required so...
        return todos.stream()
                .filter(t -> t.todo.equals(todo))
                .collect(Collectors.toList());
    }

    public TodoItem createTodo(TodoItem todoItem) {
        logger.info("Creating new Todo: " + todoItem.todo);
        return todoRepository.save(todoItem);
    }

    public TodoItem updateTodo(TodoItem todoItem) {
        logger.info("Updating todo: " + todoItem.id);
        return todoRepository.save(todoItem);
    }

    public Iterable<TodoItem> deleteTodo(Long id) {
        logger.info("Deleting todo: " + id);
        todoRepository.delete(id);
        return todoRepository.findAll();
    }
}
