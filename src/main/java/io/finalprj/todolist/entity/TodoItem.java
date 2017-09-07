package io.finalprj.todolist.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
public class TodoItem {
    @Id
    @GeneratedValue(strategy  = GenerationType.AUTO)
    public long id;

    @Column(name= "TODO")
    @JsonProperty("todo")
    public String todo;

    @Column(name= "STATUS", nullable = false)
    @JsonProperty("status")
    public Boolean status;

    public TodoItem() {
    }

    public TodoItem(String todo, Boolean status) {
        this.todo = todo;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTodo() {
        return todo;
    }

    public void setToDo(String todo) {
        this.todo = todo;
    }
}
