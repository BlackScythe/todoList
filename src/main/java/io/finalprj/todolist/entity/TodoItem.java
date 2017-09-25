package io.finalprj.todolist.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;


@Entity
@Table(name = "TODOS")
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private User user;

    public TodoItem() {
    }

    public TodoItem(String todo, Boolean status) {
        this.todo = todo;
        this.status = status;
    }

    public TodoItem(String todo, Boolean status, User user) {
        this.todo = todo;
        this.status = status;
        this.user = user;
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

    public void setTodo(String todo) {
        this.todo = todo;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
