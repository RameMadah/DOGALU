package com.example.htw.berlin.webtech.demo.web.api;

public class Lesson {

    private int lid;
    private String title;
    private String  description;
    private int punkte;


    public Lesson(int lid, String title, String description, int punkte) {
        this.lid = lid;
        this.title = title;
        this.punkte = punkte;
        this.description = description;
    }

    public int getLid() {
        return lid;
    }

    public void setLid(int lid) {
        this.lid = lid;
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

    public int getPunkte() {
        return punkte;
    }

    public void setPunkte(int punkte) {
        this.punkte = punkte;
    }
}
