package com.n1k0.RESTtest.controller;

import com.n1k0.RESTtest.exception.UserAlreadyExistException;
import com.n1k0.RESTtest.exception.UserNotFoundException;
import com.n1k0.RESTtest.entity.UserEntity;
import com.n1k0.RESTtest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/registration")
    public ResponseEntity registration(@RequestBody UserEntity userEntity) {
        try {
            userService.registration(userEntity);
            return ResponseEntity.ok().body("Пользователь сохранен!");
        } catch (UserAlreadyExistException u) {
            return ResponseEntity.badRequest().body(u.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @GetMapping
    public ResponseEntity getOneUser(@RequestParam Long id) {
        try {
            return ResponseEntity.ok().body(userService.getOne(id));
        }catch (UserNotFoundException u){
            return ResponseEntity.badRequest().body(u.getMessage());
        }catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id){
        try {
            return ResponseEntity.ok().body("Пользователь с id = " + userService.delete(id) + " удален!");
        }catch (UserNotFoundException u){
            return ResponseEntity.badRequest().body(u.getMessage());
        }catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }
}
