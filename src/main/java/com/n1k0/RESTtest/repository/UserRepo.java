package com.n1k0.RESTtest.repository;

import com.n1k0.RESTtest.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<UserEntity, Long> {
    UserEntity findByName(String name);
}
