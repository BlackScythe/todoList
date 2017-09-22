/*
package io.finalprj.todolist.service;

import io.finalprj.todolist.entity.User;
import io.finalprj.todolist.repository.UserRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    private static final Logger LOGGER = Logger.getLogger(TodoService.class);
    private static final String TODO = "todo";
    private static final String STATUS = "status";
    private static final String NAME = "name";


    public List<User> getUsers(Map<String, String> query) {
        LOGGER.info(query);
        return userRepository.findAll();
    }

    public User getUser(Long id) {
        return userRepository.findOne(id);
    }
}
*/
