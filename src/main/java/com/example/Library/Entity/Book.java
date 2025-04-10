package com.example.Library.Entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@Entity
// @Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "book")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Book {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(nullable = false, length = 255)
  private String name;

  @Column(nullable = false, length = 25)
  private String genre;

  @Column(nullable = false, length = 255)
  private String annotations;

  @Column(name = "printed_date", nullable = false)
  private LocalDateTime printedDate;

  @Column(nullable = false, length = 50)
  private String publisher;

  @Column(name = "language_book", nullable = false, length = 25)
  private String languageBook;

  @Column(name = "page_size", nullable = false)
  private Integer pageSize;

  @ManyToMany
  @JoinTable(
      name = "books_authors",
      joinColumns = @JoinColumn(name = "book_id"),
      inverseJoinColumns = @JoinColumn(name = "author_id"))
  private Set<Author> authors;

  @OneToOne(mappedBy = "book", fetch = FetchType.LAZY)
  BookStatus bookStatus;


}
