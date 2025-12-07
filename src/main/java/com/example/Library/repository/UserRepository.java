package com.example.Library.repository;

import com.example.Library.dto.UserDTO;
import com.example.Library.dto.UserDetailDTO;
import com.example.Library.entity.User;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Integer> {

  // JPQL
  @Query("SELECT u FROM User u JOIN FETCH u.books")
  List<User> findAllWithBooks(); // not work Lazy init

  @Query(
      "SELECT NEW com.example.Library.dto.UserDTO(u.id, u.name, u.surname, u.email, u.phoneNumber) FROM User u")
  List<UserDTO> findAllUserDTO();

  @Query(
      """
    SELECT NEW com.example.Library.dto.UserDetailDTO(
        NEW com.example.Library.dto.UserDTO(u.id, u.name, u.surname, u.email, u.phoneNumber),
        a.country,
        a.city,
        a.street,
        a.house
    )
    FROM User u
    JOIN u.address a
    WHERE u.id = :userId
""")
  Optional<UserDetailDTO> getUserDetail(@Param("userId") Integer userId);
}
