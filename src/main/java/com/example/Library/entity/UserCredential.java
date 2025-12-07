package com.example.Library.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(onlyExplicitlyIncluded = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "user_credential")
public class UserCredential implements BaseEntity<Integer> {
  @Id
  @Column(name = "id")
  @EqualsAndHashCode.Include
  private Integer id;

  @Column(name = "password_hash", nullable = false)
  private String pass;

  @OneToOne
  @MapsId
  @JoinColumn(name = "id")
  @JsonIgnore
  private User user;
}
