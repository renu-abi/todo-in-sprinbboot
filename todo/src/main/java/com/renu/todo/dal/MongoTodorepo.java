package com.renu.todo.dal;

import com.renu.todo.model.Todomodel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MongoTodorepo implements Todorepo{
    @Autowired
    private Mongorepo mongoRepo;

    @Override
    public List<Todomodel> getAllTodo() {
        System.out.println("Get repo");
        return mongoRepo.findAll();
    }

    @Override
    public Todomodel createTodo(Todomodel todo_entry) {
        return mongoRepo.save(todo_entry);
    }

    @Override
    public Todomodel updateTodo(Todomodel todo_entry, String id) {
        Todomodel oldEntry = mongoRepo.findById(id).get();
        oldEntry.setTitle(todo_entry.getTitle());
        oldEntry.setDescription(todo_entry.getDescription());
        return mongoRepo.save(oldEntry);
    }

    @Override
    public String deleteTodo(String id) {
        mongoRepo.deleteById(id);
        return "Deleted successfully";
    }
}
