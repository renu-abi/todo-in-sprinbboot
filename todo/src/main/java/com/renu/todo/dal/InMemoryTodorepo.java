package com.renu.todo.dal;

import com.renu.todo.model.Todomodel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
public class InMemoryTodorepo implements Todorepo{
    private HashMap<String, Todomodel> todoMap = new HashMap<>();
    private int currentId = 1;

    @Override
    public List<Todomodel> getAllTodo() {

        return new ArrayList<>(todoMap.values());
    }

    @Override
    public Todomodel createTodo(Todomodel todo_entry) {
        String id = String.valueOf(currentId++);
        todo_entry.setId(id);
        todoMap.put(id, todo_entry);
        return todo_entry;
    }

    @Override
    public Todomodel updateTodo(Todomodel todo_entry, String id) {
        if(todoMap.containsKey(id)){
            Todomodel existingTodo = todoMap.get(id);
            existingTodo.setTitle(todo_entry.getTitle());
            existingTodo.setDescription(todo_entry.getDescription());
            return existingTodo;
        }
        return null;
    }

    @Override
    public String deleteTodo(String id) {
        todoMap.remove(id);
        return "Deleted Successfully";
    }
}
