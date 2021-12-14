package com.example.htw.berlin.webtech.demo.persistence;

import javax.persistence.*;


@Entity(name = "lessons")
public class LessonEntity {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name = "lid" ,nullable = false)
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "punkte")
    private int punkte;

    protected LessonEntity() {

    }


    public LessonEntity(String title,String description, int punkte) {
        this.title = title;
        this.punkte = punkte;
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
