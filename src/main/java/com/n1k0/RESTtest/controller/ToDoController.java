package com.n1k0.RESTtest.controller;

import com.n1k0.RESTtest.entity.ToDoEntity;
import com.n1k0.RESTtest.entity.UserEntity;
import com.n1k0.RESTtest.exception.ToDoNotFoundException;
import com.n1k0.RESTtest.exception.UserNotFoundException;
import com.n1k0.RESTtest.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todos")
public class ToDoController {

    @Autowired
    private ToDoService toDoService;

    @PostMapping
    public ResponseEntity createToDo(@RequestParam Long userId,
                                     @RequestBody ToDoEntity todo) {
        try {
            return ResponseEntity.ok().body("Успешно создана задача: " + toDoService.create(todo, userId).getTitle() +
                    " для пользователя " + userId);
        } catch (UserNotFoundException u) {
            return ResponseEntity.badRequest().body(u.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка создания задачи!");
        }
    }

    @PutMapping
    public ResponseEntity completeToDo(@RequestParam Long id) {

        try {
            return ResponseEntity.ok().body(toDoService.complete(id));
        } catch (ToDoNotFoundException t) {
            return ResponseEntity.badRequest().body(t.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }
}
