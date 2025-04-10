package com.example.Library.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Set;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users_info")
public class UserInfo implements BaseEntity<Integer> {
  @Id
  @Column(name = "id", nullable = false)
  private Integer id;

  @Column(name = "registrate_time", nullable = true)
  private Timestamp registerTime;

  @Column(name = "last_visit_time", nullable = true)
  private Timestamp lastVisitTime;

  private BigDecimal balance;

  @Enumerated(EnumType.STRING)
  private EnumUserRole role;

  @Enumerated(EnumType.STRING)
  private EnumUserStatus status;

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "id", referencedColumnName = "id", nullable = false)
  @JsonIgnore
  User user;


}
