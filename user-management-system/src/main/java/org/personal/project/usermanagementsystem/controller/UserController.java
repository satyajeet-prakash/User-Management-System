package org.personal.project.usermanagementsystem.controller;

import org.personal.project.usermanagementsystem.models.User;
import org.personal.project.usermanagementsystem.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @RequestMapping("/user")
    public List<User> getAllUsersList() {
        return userService.getAllUsers();
    }
    @RequestMapping("/user/{userId}")
    public ResponseEntity<?> getUserById(@PathVariable Long userId) {
        try {
            return ResponseEntity.ok(userService.getUserById(userId));
        } catch(Exception e) {
            return new ResponseEntity<String>("No User found with Id : " + userId, HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping(value = "/user", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> addUser(@RequestBody User user) {
        userService.saveUser(user);
        return  ResponseEntity.ok("Thanks for Posting");
    }
    @PutMapping(value="/user/{userId}")
    public ResponseEntity<String> updateUser(@PathVariable Long userId, @RequestBody User user) {
        try {
            userService.updateAllUserColumns(userId, user);
            return ResponseEntity.ok("Successfully Updated");
        } catch(Exception e) {
            return new ResponseEntity<String>("No User found with Id : " + userId, HttpStatus.BAD_REQUEST);
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
