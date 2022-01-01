package com.example.htw.berlin.webtech.demo;

import com.example.htw.berlin.webtech.demo.service.LessonService;
import com.example.htw.berlin.webtech.demo.web.api.Lesson;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.contains;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(LessonRestController.class)
class LessonRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LessonService lessonService;


    @Test
    @DisplayName("should return find lesson through lesson Service")
    void fetchLessons() throws Exception {


        var lessons = List.of(
                new Lesson(1, "jump", "up", 40),
                new Lesson(2, "crawl", "down", 45)
        );

        doReturn(lessons).when(lessonService).findAll();
        mockMvc.perform(get("/api/v1/lessons"))
                .andExpect(status().isOk())

                .andExpect(jsonPath("$[0].lid").value(1))
                .andExpect(jsonPath("$[0].title").value("jump"))
                .andExpect(jsonPath("$[0].description").value("up"))
                .andExpect(jsonPath("$[0].punkte").value(40))

                .andExpect(jsonPath("$[1].lid").value(2))
                .andExpect(jsonPath("$[1].title").value("crawl"))
                .andExpect(jsonPath("$[1].description").value("down"))
                .andExpect(jsonPath("$[1].punkte").value(45));
    }
}
