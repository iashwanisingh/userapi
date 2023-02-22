package com.userapi.user.controller;

import com.userapi.user.entity.User;
import com.userapi.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

  @Autowired
  private UserService userService;

  @GetMapping("/users")
  public ResponseEntity<List<User>> getUser() {
    List<User> users = this.userService.getUser();
    if (users.isEmpty()) {
      return ResponseEntity.status(HttpStatus.valueOf(404)).build();
    }
    return ResponseEntity.of(Optional.of(users));
  }

  //Get User By Id
  @GetMapping("/user/{userId}")
  public ResponseEntity<User> getUserById(@PathVariable("userId") int userId) {
    try {
      return ResponseEntity.of(Optional.of(this.userService.getUserById(userId)));
    } catch (Exception e) {
      e.printStackTrace();
    }
    return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

  }

  //create user
  @PostMapping("/users")
  public ResponseEntity<User> addUser(@RequestBody User user) {
    return ResponseEntity.of(Optional.of(this.userService.addUser(user)));
  }

  //update user
  @PutMapping("/user/{userId}")
  public ResponseEntity<User> updateBook(@RequestBody User user) {
    try {
      return ResponseEntity.of(Optional.of(this.userService.updateUser(user)));
    } catch (Exception e) {
      e.printStackTrace();
    }
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
  }

  //delete user
  @DeleteMapping("/users/{userId}")
  public ResponseEntity<HttpStatus> deleteUser(@PathVariable("userId") int userId) {
    try {
      this.userService.deleteUser(userId);
      System.out.println(ResponseEntity.ok("User with UserId " + userId + " successfully removed from database."));
      return ResponseEntity.status(HttpStatus.valueOf(200)).build();
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
  }
}



