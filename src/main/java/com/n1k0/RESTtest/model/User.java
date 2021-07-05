package com.n1k0.RESTtest.model;

import com.n1k0.RESTtest.entity.UserEntity;

import java.util.List;
import java.util.stream.Collectors;

public class User {
    private Long id;
    private String name;
    private List<ToDo> todos;

    public User() {
    }

    public static User toModel(UserEntity userEntity){
        User model = new User();
        model.setName(userEntity.getName());
        model.setId(userEntity.getId());
        model.setTodos(userEntity.getTodos().stream().map(ToDo::toModel).collect(Collectors.toList()));

        return model;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ToDo> getTodos() {
        return todos;
    }

    public void setTodos(List<ToDo> todos) {
        this.todos = todos;
    }
}
