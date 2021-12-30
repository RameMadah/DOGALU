package com.example.htw.berlin.webtech.demo.service;

import com.example.htw.berlin.webtech.demo.persistence.BlogEntity;
import com.example.htw.berlin.webtech.demo.persistence.LessonEntity;
import com.example.htw.berlin.webtech.demo.persistence.LessonRepository;
import com.example.htw.berlin.webtech.demo.web.api.Lesson;
import com.example.htw.berlin.webtech.demo.web.api.LessonCreateRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;
@ExtendWith(MockitoExtension.class)
class LessonServiceTest {

    @Mock
    private LessonRepository repository;

    @InjectMocks
    private LessonService underTest;
    @Test
    @DisplayName( "should Check if transforming from Lesson-Entity to object works")
    void entityToLesson() {
        var ent = Mockito.mock(LessonEntity.class);
        doReturn(1).when(ent).getId();
        doReturn(35).when(ent).getPunkte() ;
        doReturn("dont shout at your dog or he will ..").when(ent).getDescription();
        doReturn("Dogalu").when(ent).getTitle();


        // when
        var result = underTest.entityToLesson(ent);

        // then
        assertThat(result.getLid()).isEqualTo(1);
        assertThat(result.getPunkte()).isEqualTo(35);
        assertThat(result.getDescription()).isEqualTo("dont shout at your dog or he will ..");
        assertThat(result.getTitle()).isEqualTo("Dogalu");
    }



}
