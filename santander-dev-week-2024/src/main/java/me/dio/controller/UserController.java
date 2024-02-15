package me.dio.controller;

import me.dio.model.User;
import me.dio.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;


@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){
    User user = userService.findById(id);
    return ResponseEntity.ok().body(user);
    }

    @PostMapping
    public ResponseEntity<User> create(@RequestBody User userToCreated){
        var userCreated = userService.create(userToCreated);
        URI localtion = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(userToCreated.getId()).toUri();
        return ResponseEntity.created(localtion).body(userCreated);
    }

}
