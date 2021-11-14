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

    @Column(name = "punkte")
    private int punkte;

    protected LessonEntity() {

    }


    public LessonEntity(String title, int punkte) {
        this.title = title;
        this.punkte = punkte;
    }

    public int getId() {
        return id;
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
