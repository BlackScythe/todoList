package io.finalprj.todolist.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.xml.internal.bind.v2.TODO;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "USERS")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "NAME")
    @JsonProperty("name")
    private String name;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TodoItem> todoItems = new ArrayList<>();

    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TodoItem> getTodoItems() {
        return todoItems;
    }

    public void addTodoItem(List<TodoItem> todoItems) {
        this.todoItems.addAll(todoItems);
    }
}
