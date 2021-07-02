package com.n1k0.RESTtest.model;

import com.n1k0.RESTtest.entity.UserEntity;

public class User {
    private Long id;
    private String name;

    public User() {
    }

    public static User toModel(UserEntity userEntity){
        User model = new User();
        model.setName(userEntity.getName());
        model.setId(userEntity.getId());

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
}
