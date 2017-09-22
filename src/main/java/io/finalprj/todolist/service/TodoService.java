package io.finalprj.todolist.service;

import io.finalprj.todolist.entity.TodoItem;
import io.finalprj.todolist.repository.TodoRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    private static final Logger LOGGER = Logger.getLogger(TodoService.class);
    private static final String TODO = "todo";
    private static final String STATUS = "status";

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<TodoItem> getTodos(Map<String, String> query) {
        if (query.get(TODO) != null && query.get(STATUS) != null) {
            LOGGER.info("Getting all Todos where todo is: " + query.get(TODO) + " and status is: " + query.get(STATUS));
            return todoRepository.findByTodoAndStatus(
                    query.get(TODO),
                    query.get(STATUS).equals("true") ? true : false
            );
        }

        if (query.get(TODO) != null) {
            LOGGER.info("Getting all Todos where todo is:" + query.get(TODO));
            return todoRepository.findByTodo(query.get(TODO));
        }

        if (query.get(STATUS) != null) {
            LOGGER.info("Getting all Todos where status is:" + query.get(STATUS));
            return todoRepository.findByStatus(query.get(STATUS).equals("true") ? true : false);
        }
        return todoRepository.findAll();
    }

    public TodoItem getTodo(Long id) {
        LOGGER.info("Getting todo: " + id);
        return todoRepository.findOne(id);
    }

    public TodoItem createTodo(TodoItem todoItem) {
        LOGGER.info("Creating new Todo: " + todoItem.getTodo());
        return todoRepository.save(todoItem);
    }

    public TodoItem updateTodo(TodoItem todoItem) {
        LOGGER.info("Updating todo: " + todoItem.getId());
        return todoRepository.save(todoItem);
    }

    public List<TodoItem> deleteTodo(Long id) {
        LOGGER.info("Deleting todo: " + id);
        todoRepository.delete(id);
        return todoRepository.findAll();
    }
}
