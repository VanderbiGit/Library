package com.example.Library.entity;

import jakarta.persistence.*;
import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users_info")
public class UserInfo implements BaseEntity<Integer> {
  @Id
  @Column(name = "id", nullable = false)
  private Integer id;

  @Column(name = "registered")
  private Timestamp registered;

  @Column(name = "last_visit")
  private Timestamp lastVisit;

  @Enumerated(EnumType.STRING)
  private EnumUserRole role;

  @Enumerated(EnumType.STRING)
  private EnumAccountStatus status;

  //  @OneToOne
  //  @MapsId
  //  @JoinColumn(name = "id")
  //  @JsonIgnore
  //  User user;
}
