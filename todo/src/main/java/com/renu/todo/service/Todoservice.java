package com.renu.todo.service;

import com.renu.todo.dal.Todorepo;
import com.renu.todo.model.Todomodel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Todoservice {
    @Autowired
    private Todorepo todoRepo;

    public List<Todomodel> getTodoService(){
        System.out.println("Service get: ");
        return todoRepo.getAllTodo();
    }
    public Todomodel createTodoService(Todomodel todo_entry){

        return todoRepo.createTodo(todo_entry);
    }
    public Todomodel updateTodoService(Todomodel todo_entry,String id){

        return todoRepo.updateTodo(todo_entry, id);
    }
    public String deleteTodoService(String id){

        return todoRepo.deleteTodo(id);
    }

}
