package com.example.Library.controller;

import com.example.Library.entity.Author;
import com.example.Library.service.AuthorService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
