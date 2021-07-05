package com.n1k0.RESTtest.model;

import com.n1k0.RESTtest.entity.ToDoEntity;
import com.n1k0.RESTtest.entity.UserEntity;

public class ToDo {
    private Long id;
    private String title;
    private Boolean completed;

    public static ToDo toModel(ToDoEntity toDoEntity){
        ToDo model = new ToDo();
        model.setTitle(toDoEntity.getTitle());
        model.setId(toDoEntity.getId());
        model.setCompleted(toDoEntity.getCompleted());

        return model;
    }

    public ToDo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }
}
