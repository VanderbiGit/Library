package com.example.Library.controller;

import com.example.Library.entity.Book;
import com.example.Library.service.BookService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

  private final BookService bookService;

  BookController(BookService bookService) {
    this.bookService = bookService;
  }

  @GetMapping(value = "/books", produces = "application/json")
  public @ResponseBody List<Book> allBooks() {
    return bookService.getAllBooks();
  }
}
