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
@Table(name = "book_info")
public class BookInfo implements BaseEntity<Integer> {

  @EqualsAndHashCode.Include @Id private Integer id;
  private Integer price;

  @Column(nullable = false, length = 100)
  private String location;

  @Column(nullable = false, length = 512)
  private String note;

  @OneToOne
  @MapsId
  @JoinColumn(name = "id")
  @JsonIgnore
  Book book;
}
