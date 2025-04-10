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
@Table(name = "book_status")
public class BookStatus implements BaseEntity<Integer> {

  @Id private Integer id;
  private Integer price;
  private Integer discount;
  private String location;

  @Column(name = "additional_information")
  private String additionalInformation;

  @OneToOne
  @JoinColumn(name = "id", referencedColumnName = "id", nullable = false)
  @JsonIgnore
  Book book;

  public int hashCode() {
    return 0;
  }


}
