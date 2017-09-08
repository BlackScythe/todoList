package io.finalprj.todolist.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;


@Entity
public class TodoItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "TODO")
    @JsonProperty("todo")
    private String todo;

    @Column(name = "STATUS", nullable = false)

    @JsonProperty("status")
    private Boolean status;

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

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
