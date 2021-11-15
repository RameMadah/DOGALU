package com.example.htw.berlin.webtech.demo;
import com.example.htw.berlin.webtech.demo.service.UserService;
import com.example.htw.berlin.webtech.demo.web.api.User;
import com.example.htw.berlin.webtech.demo.web.api.UserCreateRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;




@RestController
public class UserRestController {

    private final UserService userService;

    public UserRestController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping(path = "/api/v1/users")
    public ResponseEntity<List<User>> fetchUsers() {
        return ResponseEntity.ok(userService.findAll()) ;
}


    @GetMapping(path = "/api/v1/users/{id}")
    public ResponseEntity<User> fetchUserById(@PathVariable int id) {
        var user = userService.findUserbyId(id);
        return user != null? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
    }

    @PutMapping(path = "/api/v1/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable int id,@RequestBody UserCreateRequest request ) {
        var user = userService.update(id,request);
        return user != null? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
    }


    @PostMapping(path = "/api/v1/users")
    public ResponseEntity<Void> createUser(@RequestBody UserCreateRequest request) throws URISyntaxException {

        var user = userService.create( request );
        URI uri = new URI("/api/v1/users/"+ user.getId());
       return ResponseEntity.created(uri).build();

    }

@DeleteMapping(path = "/api/v1/users/{id}")
    public ResponseEntity<Void> deleteUser (@PathVariable int id){
     boolean user = userService.deleteById(id) ;
    return user? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }




}
