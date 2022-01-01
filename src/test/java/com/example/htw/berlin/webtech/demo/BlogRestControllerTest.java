package com.example.htw.berlin.webtech.demo;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.example.htw.berlin.webtech.demo.service.BlogService;
import com.example.htw.berlin.webtech.demo.web.api.Blog;
import static org.mockito.ArgumentMatchers.anyInt;

@WebMvcTest(BlogRestController.class)
class BlogRestControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BlogService blogService;

    @Test
    @DisplayName("should check  all fetched Data ")
    void fetchBlogs() throws Exception {


        var blogs = List.of(
                new Blog(1, "posalu", "here you can post", "me"),
                new Blog(2, "blogalu", "here you can blog", "he")
        );

        doReturn(blogs).when(blogService).findAll();


        mockMvc.perform(get("/api/v1/blogs"))


                .andExpect(status().isOk())

                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].title").value("posalu"))
                .andExpect(jsonPath("$[0].description").value("here you can post"))
                .andExpect(jsonPath("$[0].author").value("me"))

                .andExpect(jsonPath("$[1].id").value(2))
                .andExpect(jsonPath("$[1].title").value("blogalu"))
                .andExpect(jsonPath("$[1].description").value("here you can blog"))
                .andExpect(jsonPath("$[1].author").value("he"));



    }

    @Test
    @DisplayName("should return 404 Er if Blog doesnt exist ")
    void find404() throws Exception {
        doReturn(null).when(blogService).findById(anyInt());

        mockMvc.perform(get("/api/v1/blogs/888"))
                .andExpect(status().isNotFound());
    }

}
