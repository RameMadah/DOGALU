package com.example.htw.berlin.webtech.demo;

import com.example.htw.berlin.webtech.demo.service.LessonService;
import com.example.htw.berlin.webtech.demo.web.api.Lesson;
import com.example.htw.berlin.webtech.demo.web.api.LessonCreateRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;


    @RestController
    public class LessonRestController {

        private final LessonService lessonService;

        public LessonRestController(LessonService lessonService) {
            this.lessonService = lessonService;
        }


        @GetMapping(path = "/api/v1/lessons")
        public ResponseEntity<List<Lesson>> fetchLessons() {
            return ResponseEntity.ok(lessonService.findAll()) ;
        }


        @GetMapping(path = "/api/v1/lessons/{lid}")
        public ResponseEntity<Lesson> fetchLessonById(@PathVariable int lid) {
            var lesson = lessonService.findById(lid);
            return lesson != null? ResponseEntity.ok(lesson): ResponseEntity.notFound().build() ;
        }



        @PostMapping(path = "/api/v1/lessons")
        public ResponseEntity<Void> CreateLesson(@RequestBody LessonCreateRequest request) throws URISyntaxException {

            var lesson = lessonService.createl( request );
            URI uri = new URI("/api/v1/lessons/"+ lesson.getTitle());
            return ResponseEntity.created(uri).build();

        }



    }


