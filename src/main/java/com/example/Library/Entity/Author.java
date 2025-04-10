package com.example.Library.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@Entity
//@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "author")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Author {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(nullable = false, length = 255)
  private String name;

  @Column(name = "sur_name", nullable = false, length = 25)
  private String surName;

  @Column(nullable = false)
  private LocalDateTime birthday;

  @Column(name = "date_death")
  private LocalDateTime dateDeath;

  @Column(name = "short_bio", nullable = false, length = 500)
  private String shortBio;

  @Column(nullable = false, length = 100)
  private String address;

  @ManyToMany(mappedBy = "authors")
  private Set<Book> books;

}
