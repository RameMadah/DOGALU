package com.example.htw.berlin.webtech.demo.web.api;

public class Lesson {

    private int id;
    private String title;
    private int punkte;


    public Lesson(int id, String title, int punkte) {
        this.id = id;
        this.title = title;
        this.punkte = punkte;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
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
