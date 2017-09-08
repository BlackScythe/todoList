package io.finalprj.todolist.controller;

import io.finalprj.todolist.entity.TodoItem;
import io.finalprj.todolist.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Optional;

@RestController
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    private TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public Iterable<TodoItem> getTodos(@RequestParam Optional<Long> id, @RequestParam Optional<Boolean> status, @RequestParam Optional<String> todo) {
        if (id.isPresent()) {
            return Arrays.asList(todoService.getTodo(id.get()));
        }
        if (todo.isPresent()) {
            return todoService.getTodo(todo.get());
        }
        if (status.isPresent()) {
            return todoService.getStatusTodos(status.get());
        }
        return todoService.getTodos();
    }

    @PostMapping
    public TodoItem createTodo(@RequestBody TodoItem todoItem) {
        return todoService.createTodo(todoItem);
    }

    @PatchMapping
    public TodoItem updateTodo(@RequestBody TodoItem todoItem) {
        return todoService.updateTodo(todoItem);
    }

    @DeleteMapping
    public Iterable<TodoItem> deleteTodos(@RequestParam("id") Long id) {
        return todoService.deleteTodo(id);
    }

}
