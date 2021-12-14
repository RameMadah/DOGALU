
package com.example.htw.berlin.webtech.demo.web.api;

public class LessonCreateRequest {
    private String title;
    private String description;
    private int punkte;

    public LessonCreateRequest(String title,String description ,int punkte) {
        this.title = title;
        this.punkte = punkte;
        this.description = description;
    }
  public LessonCreateRequest(){}

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPunkte() {
        return punkte;
    }

    public void setPunkte(int punkte) {
        this.punkte = punkte;
    }
}
