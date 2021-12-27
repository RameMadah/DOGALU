
package com.example.htw.berlin.webtech.demo.web.api;

public class BlogCreateRequest {
    private String title;
    private String description;
    private String author;

    public BlogCreateRequest(String title, String description , String author) {
        this.title = title;
        this.description = description;
    }
  public BlogCreateRequest(){}

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
