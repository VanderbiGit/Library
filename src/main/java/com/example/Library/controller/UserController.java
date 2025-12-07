package com.example.Library.controller;

import com.example.Library.dto.UserDTO;
import com.example.Library.dto.UserDetailDTO;
import com.example.Library.service.UserService;
import java.util.List;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

  private final UserService userService;

  UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping(produces = "application/json")
  public @ResponseBody List<UserDTO> allUsers() {
    return userService.getAllUser();
  }

  @GetMapping(value = "/{id}", produces = "application/json")
  public @ResponseBody UserDetailDTO userDetail(@PathVariable Integer id) {
    return userService.getUserDetail(id);
  }
}
