package com.n1k0.RESTtest.service;

import com.n1k0.RESTtest.entity.UserEntity;
import com.n1k0.RESTtest.exception.UserAlreadyExistException;
import com.n1k0.RESTtest.exception.UserNotFoundException;
import com.n1k0.RESTtest.model.User;
import com.n1k0.RESTtest.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public UserEntity registration(UserEntity userEntity) throws UserAlreadyExistException {
        if(userRepo.findByName(userEntity.getName()) != null){
            throw  new UserAlreadyExistException("Пользователь с таким именем уже существует!");
        }
        return userRepo.save(userEntity);
    }

    public User getOne(Long id) throws UserNotFoundException {

        if(userRepo.findById(id).isEmpty()){
            throw new UserNotFoundException("Такого пользователя не существует!");
        }
        return User.toModel(userRepo.findById(id).get());
    }

    public Long delete(Long id) throws  UserNotFoundException{
        if(userRepo.findById(id).isEmpty()){
            throw new UserNotFoundException("Такого пользователя не существует!");
        }
        userRepo.deleteById(id);
        return id;
    }
}
