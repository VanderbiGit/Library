package com.example.Library.service;

import com.example.Library.entity.Author;
import com.example.Library.repository.AuthorRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {
  private final AuthorRepository authorRepository;

  AuthorService(AuthorRepository authorRepository) {
    this.authorRepository = authorRepository;
  }

  public List<Author> getAllAuthors() {
    return authorRepository.findAll();
  }
}
