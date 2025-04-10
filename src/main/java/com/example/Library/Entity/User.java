package com.example.Library.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User implements BaseEntity<Integer>{

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  @Column(nullable = false)
  private String surName;

  @Column(nullable = false)
  private String address;

  @Column(nullable = false, unique = true)
  private String email;

  @Column(nullable = false)
  private String phone_number;

  @OneToOne(mappedBy = "user", fetch = FetchType.LAZY)
  UserInfo userInfo;

  @OneToOne(mappedBy = "user", fetch = FetchType.LAZY)
  UserCredential credential;


  @OneToMany(fetch = FetchType.LAZY)
  @JoinTable(
          name = "users_books",
          joinColumns = @JoinColumn(name = "user_id"),
          inverseJoinColumns = @JoinColumn(name = "book_id"))
  Set<Book> books;
}
