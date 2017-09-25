package io.finalprj.todolist.controller;

import io.finalprj.todolist.entity.TodoItem;
import io.finalprj.todolist.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    private TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public List<TodoItem> getTodos(@RequestParam Map<String, String> query) {
        return todoService.getTodos(query);
    }

    @GetMapping("/{id}")
    public TodoItem getTodo(@PathVariable Long id) {
        return todoService.getTodo(id);
    }

    @PostMapping
    public TodoItem createTodo(@RequestBody TodoItem todoItem) {
        return todoService.createTodo(todoItem);
    }

    @PutMapping
    public TodoItem updateTodo(@RequestBody TodoItem todoItem) {
        return todoService.updateTodo(todoItem);
    }

    @DeleteMapping
    public Iterable<TodoItem> deleteTodos(@RequestParam("id") Long id) {
        return todoService.deleteTodo(id);
    }

}
