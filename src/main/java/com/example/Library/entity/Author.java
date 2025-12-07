package com.example.Library.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "author")
public class Author {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Integer id;

  @Column(nullable = false)
  private String name;

  @Column(name = "surname", nullable = false, length = 25)
  private String surname;

  @Column(nullable = false)
  private LocalDateTime birthday;

  @Column(name = "date_death")
  private LocalDateTime dateDeath;

  @Column(name = "short_bio", nullable = false, length = 500)
  private String biography;

  @ManyToMany(mappedBy = "authors")
  private List<Book> books = new ArrayList<>();
}
