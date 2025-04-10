package com.example.Library.Controller;

import com.example.Library.Entity.User;
import com.example.Library.Service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    private final UserService userService;
    UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping(value = "/users", produces = "application/json")
    public @ResponseBody List<User> allUsers() {
        return userService.getAllUser();
    }

}
