
package com.example.htw.berlin.webtech.demo.web.api;

public class BlogCreateRequest {
    private String title;
    private String description;


    public BlogCreateRequest(String title, String description ) {
        this.title = title;
        this.description = description;
    }
  public BlogCreateRequest(){}

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
