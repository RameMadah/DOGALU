package com.example.htw.berlin.webtech.demo.service;

import com.example.htw.berlin.webtech.demo.persistence.BlogEntity;
import com.example.htw.berlin.webtech.demo.web.api.BlogCreateRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;

class BlogServiceTest {
    private final BlogService b = new BlogService(null);
    @Test
    @DisplayName( "should Check if transforming from Blog-Entity to object works")
    void entityToBlog() {
        var ent = Mockito.mock(BlogEntity.class);
        doReturn(8).when(ent).getId();
        doReturn("Rame Madah").when(ent).getAuthor();
        doReturn("once Upon time ..").when(ent).getDescription();
        doReturn("Dogalu").when(ent).getTitle();

        var result = b.entityToBlog(ent);

        assertThat(result.getid()).isEqualTo(8);
        assertThat(result.getAuthor()).isEqualTo("Rame Madah");
        assertThat(result.getDescription()).isEqualTo("once Upon time ..");
        assertThat(result.getTitle()).isEqualTo("Dogalu");


    }



}
