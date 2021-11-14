
package com.example.htw.berlin.webtech.demo.web.api;

public class LessonCreateRequest {
    private String title;
    private int punkte;

    public LessonCreateRequest(String title, int punkte) {
        this.title = title;
        this.punkte = punkte;
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
