package com.example.Library.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(onlyExplicitlyIncluded = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "books_author")
public class BooksAuthor {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  @EqualsAndHashCode.Include
  private Integer id;

  @Column(name = "author_id", nullable = false)
  private Integer author_id;

  @Column(name = "book_id", nullable = false)
  private Integer book_id;
}
