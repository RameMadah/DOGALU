package com.example.htw.berlin.webtech.demo.persistence;

import javax.persistence.*;

@Entity
public class BlogEntity {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name = "id" ,nullable = false)
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;


    protected BlogEntity() {
    }


    public BlogEntity(String title,String description ){
        this.title = title;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }


}
