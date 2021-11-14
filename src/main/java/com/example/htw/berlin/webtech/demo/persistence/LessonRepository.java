
package com.example.htw.berlin.webtech.demo.persistence;

import com.example.htw.berlin.webtech.demo.web.api.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LessonRepository extends JpaRepository<LessonEntity,Integer > {
        List<LessonEntity>  findAll();

}

