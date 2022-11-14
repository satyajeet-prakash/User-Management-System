package org.personal.project.usermanagementsystem.controller;

import org.personal.project.usermanagementsystem.models.User;
import org.personal.project.usermanagementsystem.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @RequestMapping("/user")
    public ResponseEntity<?> getAllUsersList() {
        return ResponseEntity.ok( userService.getAllUsers());
    }
    @RequestMapping("/user/{userId}")
    public ResponseEntity<?> getUserById(@PathVariable Long userId) {
        User user = userService.getUserById(userId);
        if(user != null) {
            return ResponseEntity.ok(user);
        } else {
            return new ResponseEntity<String>("No User found with Id : " + userId, HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping(value = "/user", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addUser(@RequestBody User user) {
        userService.saveUser(user);
        URI path = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{userId}")
                .buildAndExpand(user.getUserId())
                .toUri();
        return ResponseEntity.created(path).build();
    }
    @PutMapping(value="/user")
    public ResponseEntity<String> updateUser(@RequestBody User user) {
        try {
            userService.updateAllUserColumns(user);
            return ResponseEntity.ok("Successfully Updated");
        } catch(Exception e) {
            return new ResponseEntity<String>("No User found with Id : " + user.getUserId(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "user/{userId}")
    public ResponseEntity<?> deleteUserById(@PathVariable Long userId) {
        try {
            userService.deleteUserById(userId);
            return ResponseEntity.ok("Record deleted with Id : " + userId);
        } catch(Exception e) {
            return new ResponseEntity<String>("No User found with Id : " + userId, HttpStatus.BAD_REQUEST);
        }
    }
}
