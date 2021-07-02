package com.n1k0.RESTtest.repository;

import com.n1k0.RESTtest.entity.ToDoEntity;
import com.n1k0.RESTtest.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface ToDoRepo extends CrudRepository<ToDoEntity, Long> {
    ToDoEntity findByTitle(String title);
}
