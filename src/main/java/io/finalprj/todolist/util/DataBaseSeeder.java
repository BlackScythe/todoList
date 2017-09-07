package io.finalprj.todolist.util;

import io.finalprj.todolist.entity.TodoItem;
import io.finalprj.todolist.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataBaseSeeder implements CommandLineRunner {
    private TodoRepository repository;

    @Autowired
    public DataBaseSeeder(TodoRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... strings) throws Exception {
        repository.save(new TodoItem("a", false));
        repository.save(new TodoItem("b", false));
        repository.save(new TodoItem("c", false));
        repository.save(new TodoItem("d", false));
        repository.save(new TodoItem("e", false));

    }
}
