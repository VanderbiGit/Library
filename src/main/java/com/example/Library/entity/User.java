package com.example.Library.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User implements BaseEntity<Integer> {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false)
  private String surname;

  @Column(nullable = false, unique = true)
  private String email;

  @Column(nullable = false, name = "phone_number")
  private String phoneNumber;

  @OneToOne
  @JoinColumn(name = "address_id")
  private Address address;

  @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private UserCredential credential;

  @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private UserInfo userInfo;

  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
  private List<Book> books = new ArrayList<>();
}
