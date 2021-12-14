
package com.example.htw.berlin.webtech.demo.service;


import com.example.htw.berlin.webtech.demo.persistence.LessonEntity;
import com.example.htw.berlin.webtech.demo.persistence.LessonRepository;
import com.example.htw.berlin.webtech.demo.persistence.UserEntity;
import com.example.htw.berlin.webtech.demo.persistence.UserRepository;
import com.example.htw.berlin.webtech.demo.web.api.Lesson;
import com.example.htw.berlin.webtech.demo.web.api.LessonCreateRequest;
import com.example.htw.berlin.webtech.demo.web.api.User;
import com.example.htw.berlin.webtech.demo.web.api.UserCreateRequest;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.htw.berlin.webtech.demo.persistence.LessonEntity;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LessonService {

    private final LessonRepository lessonsRepository;

    public LessonService(LessonRepository lessonsRepository) {
        this.lessonsRepository = lessonsRepository;
    }

//******************************************************************************
    //************************************************************

    public List<Lesson> findAll (){
        List<LessonEntity> lessons = lessonsRepository.findAll();
        return lessons.stream().map(this::entityToLesson).collect(Collectors.toList());
    }

    public Lesson findById (int lid){
        var lesson = lessonsRepository.findById(lid);
        return lesson.map(this::entityToLesson).orElse(null);
    }



    public Lesson createl( LessonCreateRequest request){
        var lessonEntity = new LessonEntity(request.getTitle(),request.getDescription(),request.getPunkte());
        lessonEntity = lessonsRepository.save(lessonEntity);
        return entityToLesson(lessonEntity);

    }


    public Lesson entityToLesson(LessonEntity lessonEntity){
        return new Lesson (
               lessonEntity.getId(),
                lessonEntity.getTitle(),
                lessonEntity.getDescription(),
                lessonEntity.getPunkte()
                );

    }

}
