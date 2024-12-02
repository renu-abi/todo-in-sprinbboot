package com.renu.todo.controller;

import com.renu.todo.model.Todomodel;
import com.renu.todo.service.Todoservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoController {

    @Autowired
    private Todoservice todoService;

    @GetMapping("/todos")
    public List<Todomodel> getTodoController(){
        System.out.println("get route");
        return todoService.getTodoService();
    }

    @PostMapping("/todos")
    public Todomodel createTodoController(@RequestBody Todomodel todo_entry){
        return todoService.createTodoService(todo_entry);
    }

    @PutMapping("/todos/{id}")
    public Todomodel updateTodoController(@PathVariable String id, @RequestBody Todomodel todo_entry){
        return todoService.updateTodoService(todo_entry, id);
    }

    @DeleteMapping("/todos/{id}")
    public String deleteTodoController(@PathVariable String id){

        return todoService.deleteTodoService(id);
    }
}
