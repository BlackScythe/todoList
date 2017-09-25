package io.finalprj.todolist.service;

import io.finalprj.todolist.entity.TodoItem;
import io.finalprj.todolist.entity.User;
import io.finalprj.todolist.repository.TodoRepository;
import io.finalprj.todolist.repository.UserRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TodoRepository todoRepository;

    private static final Logger LOGGER = Logger.getLogger(TodoService.class);
    private static final String TODO = "todo";
    private static final String STATUS = "status";
    private static final String NAME = "name";


    public List<User> getUsers() {
        LOGGER.info("Getting all users");
        return userRepository.findAll();
    }

    public User getUser(Long id) {

        LOGGER.info("Get user: " + id);
        return userRepository.findOne(id);
    }

    public User createUser(Map<String, Object> requestBody) {
        Set<String> keySet = requestBody.keySet();
        User user = new User((String) requestBody.get(NAME));
        userRepository.save(user);
        for (String key : keySet) {
            if (requestBody.get(key) instanceof ArrayList) {
                List<LinkedHashMap<String, Object>> todoListMap = (ArrayList) requestBody.get(key);
                List<TodoItem> todoList = new ArrayList<>();
                for (LinkedHashMap<String, Object> todoItemMap : todoListMap) {
                    TodoItem todoItem = new TodoItem((String) todoItemMap.get(TODO), (Boolean) todoItemMap.get(STATUS), user);
                    todoList.add(todoItem);
                }
                user.setTodoItems(todoList);
                todoRepository.save(todoList);
            }
        }
        LOGGER.info("Created user with tasks: " + user.getName());
        return user;
    }

    public User addUserTasks(Long id, Map<String, Object> requestBody) {
        User user = userRepository.findOne(id);
        List<LinkedHashMap<String, Object>> todoListMap = (ArrayList) requestBody.get("todoItems");
        List<TodoItem> todoList = new ArrayList<>();
        for (LinkedHashMap<String, Object> todoItemMap : todoListMap) {
            TodoItem todoItem = new TodoItem((String) todoItemMap.get(TODO), (Boolean) todoItemMap.get(STATUS), user);
            todoList.add(todoItem);
        }
        user.addTodoItem(todoList);
        todoRepository.save(todoList);
        LOGGER.info("Adding tasks to user: " + user.getName());
        return user;
    }
}
