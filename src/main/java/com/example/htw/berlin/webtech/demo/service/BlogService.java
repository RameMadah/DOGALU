package com.example.htw.berlin.webtech.demo.service;

import com.example.htw.berlin.webtech.demo.persistence.BlogEntity;
import com.example.htw.berlin.webtech.demo.persistence.BlogRepository;
import com.example.htw.berlin.webtech.demo.web.api.Blog;
import com.example.htw.berlin.webtech.demo.web.api.BlogCreateRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BlogService {

    private final BlogRepository blogRepository;


    public BlogService(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    public List<Blog> findAll (){
        List<BlogEntity> blogs = blogRepository.findAll();
        return blogs.stream().map(this::entityToBlog).collect(Collectors.toList());
    }

    public Blog findById (int lid){
        var blog = blogRepository.findById(lid);
        return blog.map(this::entityToBlog).orElse(null);
    }



    public Blog createb( BlogCreateRequest request){
        var blogEntity = new BlogEntity(request.getTitle(),request.getDescription());
        blogEntity = blogRepository.save(blogEntity);
        return entityToBlog(blogEntity);

    }


    public Blog entityToBlog(BlogEntity blogEntity){
        return new Blog (
                blogEntity.getId(),
                blogEntity.getTitle(),
                blogEntity.getDescription()
        );

    }
}
