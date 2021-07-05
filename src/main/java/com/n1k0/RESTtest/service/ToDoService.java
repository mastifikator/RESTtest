package com.n1k0.RESTtest.service;

import com.n1k0.RESTtest.entity.ToDoEntity;
import com.n1k0.RESTtest.entity.UserEntity;
import com.n1k0.RESTtest.exception.ToDoNotFoundException;
import com.n1k0.RESTtest.exception.UserNotFoundException;
import com.n1k0.RESTtest.model.ToDo;
import com.n1k0.RESTtest.repository.ToDoRepo;
import com.n1k0.RESTtest.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ToDoService {

    @Autowired
    private ToDoRepo toDoRepo;

    @Autowired
    private UserRepo userRepo;

    public ToDo create(ToDoEntity toDoEntity, Long id) throws UserNotFoundException {
        UserEntity user = userRepo.findById(id).get();

        if(userRepo.findById(id).isEmpty()){
            throw new UserNotFoundException("Такого пользователя не существует!");
        }

        toDoEntity.setUser(user);
        return ToDo.toModel(toDoRepo.save(toDoEntity));
    }

    public ToDo complete(Long id) throws ToDoNotFoundException {
        ToDoEntity toDoEntity = toDoRepo.findById(id).get();
        if(toDoEntity == null){
            throw new ToDoNotFoundException("Id задачи не найден!");
        }

        toDoEntity.setCompleted(!toDoEntity.getCompleted());
        return ToDo.toModel(toDoRepo.save(toDoEntity));
    }
}
