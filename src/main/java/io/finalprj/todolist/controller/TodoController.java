package io.finalprj.todolist.controller;

import io.finalprj.todolist.entity.TodoItem;
import io.finalprj.todolist.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping
    public Object getTodos(@RequestParam Optional<Long> id){
        if (id.isPresent()){
            return todoService.getTodo(id.get());
        }
        return todoService.getTodos();
    }

    @PostMapping
    public TodoItem createTodo(@RequestBody TodoItem todoItem){
        return todoService.createTodo(todoItem);
    }

    @PatchMapping
    public TodoItem updateTodo(@RequestBody TodoItem todoItem){
        return todoService.updateTodo(todoItem);
    }

    @DeleteMapping
    public void deleteTodos(@RequestParam("id") Long id){
        todoService.deleteTodo(id);
    }

}
