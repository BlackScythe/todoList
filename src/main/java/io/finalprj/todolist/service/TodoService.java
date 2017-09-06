package io.finalprj.todolist.service;

import io.finalprj.todolist.entity.TodoItem;
import io.finalprj.todolist.repository.TodoRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    private static final Logger logger = Logger.getLogger(TodoService.class);

    public Iterable<TodoItem> getTodos(){
        logger.info("Getting all Todos");
        return todoRepository.findAll();
    }

    public TodoItem getTodo(Long id) {
        logger.info("Getting "+id+" todo");
        return todoRepository.findOne(id);
    }

    public TodoItem createTodo(TodoItem todoItem) {
        logger.info("Creating new Todo: " + todoItem.todo);
        return todoRepository.save(todoItem);
    }

    public TodoItem updateTodo(TodoItem todoItem) {
        logger.info("Updating todo: "+ todoItem.id);
        return todoRepository.save(todoItem);
    }

    public void deleteTodo(Long id) {
        logger.info("Deleting todo: "+ id);
        todoRepository.delete(id);
    }
}
