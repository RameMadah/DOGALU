package com.example.htw.berlin.webtech.demo.web.api;

public class Blog {
    private int id;
    private String title;
    private String author;
    private String  description;



    public Blog(int id, String title, String description, String author) {
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

    public String getDescription() {
        return description;
    }


}
