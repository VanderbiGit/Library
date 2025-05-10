package com.example.Library.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import lombok.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "book")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Book {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false, length = 25)
  private String genre;

  @Column(nullable = false)
  private String annotations;

  @Column(name = "realize", nullable = false)
  private LocalDateTime realize;

  @Column(nullable = false, length = 50)
  private String publisher;

  @Column(name = "language_book", nullable = false, length = 25)
  private String languageBook;

  @Column(name = "pages", nullable = false)
  private Integer pages;

  @ManyToMany
  @JoinTable(
      name = "books_authors",
      joinColumns = @JoinColumn(name = "book_id"),
      inverseJoinColumns = @JoinColumn(name = "author_id"))
  private List<Author> authors = new ArrayList<>();

  @OneToOne(mappedBy = "book", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  BookInfo bookInfo;

  @ManyToOne
  @JoinColumn(name = "user_id")
  @JsonIgnore
  private User user;
}
