package com.example.htw.berlin.webtech.demo;

import com.example.htw.berlin.webtech.demo.service.BlogService;
import com.example.htw.berlin.webtech.demo.web.api.Blog;
import com.example.htw.berlin.webtech.demo.web.api.BlogCreateRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class BlogRestController {
    private final BlogService blogService;


    public BlogRestController(BlogService blogService) {
        this.blogService = blogService;
    }


    @GetMapping(path = "/api/v1/blogs")
    public ResponseEntity<List<Blog>> fetchBlogs() {
        return ResponseEntity.ok(blogService.findAll());
    }


    @GetMapping(path = "/api/v1/blogs/{id}")
    public ResponseEntity<Blog> fetchBlogById(@PathVariable int id) {
        var blog = blogService.findById(id);
        return blog != null ? ResponseEntity.ok(blog) : ResponseEntity.notFound().build();
    }


    @PostMapping(path = "/api/v1/blogs")
    public ResponseEntity<Void> CreateBlog(@RequestBody BlogCreateRequest request) throws URISyntaxException {
        var valid = validate(request);
        if (valid) {
            var blog = blogService.createb(request);
            URI uri = new URI("/api/v1/blogs/" + blog.getid());
            return ResponseEntity.created(uri).build();
        } else {
            return ResponseEntity.badRequest().build();
        }

    }

    private boolean validate(BlogCreateRequest request) {
        return (request.getTitle() == null
                || !request.getTitle().isBlank())
                && (request.getAuthor() == null
                || !request.getAuthor().isBlank())
                && (request.getDescription() == null
                || !request.getDescription().isBlank());
    }
}
