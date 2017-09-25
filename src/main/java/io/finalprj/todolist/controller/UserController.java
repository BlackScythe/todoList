package io.finalprj.todolist.controller;

import io.finalprj.todolist.entity.User;
import io.finalprj.todolist.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }

    @PostMapping
    public User createUser(@RequestBody Map<String, Object> requestBody) {
        return userService.createUser(requestBody);
    }

    @PostMapping("/{id}")
    public User addUserTasks(@PathVariable Long id, @RequestBody Map<String, Object> requestBody) {
        return userService.addUserTasks(id, requestBody);
    }
}
