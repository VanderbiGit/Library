package com.example.Library.controller;

import com.example.Library.entity.User;
import com.example.Library.service.UserService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

  private final UserService userService;

  UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping(value = "/users", produces = "application/json")
  public @ResponseBody List<User> allUsers() {
    return userService.getAllUser();
  }
}
