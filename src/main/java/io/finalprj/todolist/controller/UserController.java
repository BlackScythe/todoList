/*
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
    public List<User> getUsers(@RequestParam Map<String,String> queryMap) {
        return userService.getUsers(queryMap);
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id){
        return userService.getUser(id);
    }
}
*/
