package com.example.Library.service;

import com.example.Library.dto.UserDTO;
import com.example.Library.dto.UserDetailDTO;
import com.example.Library.repository.UserRepository;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  private final UserRepository userRepository;

  UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public List<UserDTO> getAllUser() {
    return userRepository.findAllUserDTO();
  }

  public UserDetailDTO getUserDetail(Integer id) {
    return userRepository
        .getUserDetail(id)
        .orElseThrow(() -> new NoSuchElementException("User with ID " + id + " not found"));
  }
}
