package io.finalprj.todolist;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import io.finalprj.todolist.entity.TodoItem;
import io.finalprj.todolist.repository.TodoRepository;

@SpringBootApplication
@EnableJpaRepositories
public class Application {
    public static void main (String[] args){
        SpringApplication.run(Application.class, args);
    }
    
    @Bean
    public CommandLineRunner loadData(TodoRepository repository) {
        return args -> {
            repository.save(new TodoItem("a", false));
            repository.save(new TodoItem("b", false));
            repository.save(new TodoItem("c", false));
            repository.save(new TodoItem("d", false));
            repository.save(new TodoItem("e", false));
        };
    }
}


