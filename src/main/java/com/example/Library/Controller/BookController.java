package com.example.Library.Controller;

import com.example.Library.Entity.Book;
import com.example.Library.Service.BookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
