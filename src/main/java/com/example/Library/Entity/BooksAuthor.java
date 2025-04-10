package com.example.Library.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "books_author")
public class BooksAuthor {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "author_id", nullable = false)
  private Integer author_id;

  @Column(name = "book_id", nullable = false)
  private Integer book_id;
}
