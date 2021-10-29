package com.example.htw.berlin.webtech.demo;


import com.example.htw.berlin.webtech.demo.web.api.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserRestController {

    private final List<User> users;

    public UserRestController(List<User> users) {
        this.users = new ArrayList<>();
        users.add(new User(1,"Rame","Madah","lawkira10@gmail.com"));
        users.add(new User(2,"Franziska","Thier","franzua@gmail.com"));

    }

    @GetMapping(path = "/api/v1/users")
    public ResponseEntity<List<User>> fetchUsers() {
    return ResponseEntity.ok(users);
}


}
