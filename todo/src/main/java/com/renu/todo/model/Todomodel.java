package com.renu.todo.model;


import jakarta.persistence.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "todos")
@Entity
@Table(name = "todos")
public class Todomodel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(nullable = true)
    private String description;

    @Column(nullable = false)
    private String title;

    public Todomodel(String title,String description,String id){
        this.title = title;
        this.description = description;
        this.id = id;
        System.out.println("Todo model cons" + id);
    }

    public String getTitle() {

        return title;
    }

    public void setTitle(String title) {

        this.title = title;
    }

    public String getDescription() {

        return description;
    }

    public void setDescription(String description) {

        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {

        this.id = id;
    }

    @Override
    public String toString() {
        return "Todomodel{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
