package com.example.htw.berlin.webtech.demo.web.api;

public class Blog {
    private int id;
    private String title;
    private String  description;
    private String author;


    public Blog(int id, String title, String description,  String author) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.author = author;
    }

    public int getid() {
        return id;
    }


    public String getAuthor() {
        return author;
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

}
