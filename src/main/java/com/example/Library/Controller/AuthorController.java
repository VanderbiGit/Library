package com.example.Library.Controller;

import com.example.Library.Entity.Author;
import com.example.Library.Entity.User;
import com.example.Library.Service.AuthorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AuthorController {

    private final AuthorService authorService;


    AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }


    @GetMapping(value = "/authors", produces = "application/json")
    public @ResponseBody List<Author> allAuthors() {
        return authorService.getAllAuthors();
    }
}
