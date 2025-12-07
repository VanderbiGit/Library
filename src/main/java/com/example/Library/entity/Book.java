package com.example.Library.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(onlyExplicitlyIncluded = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "book")
public class Book {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  @EqualsAndHashCode.Include
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

  @JsonBackReference
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id", nullable = false)
  private User user;
}
