package com.example.Library.service;

import com.example.Library.entity.User;
import com.example.Library.repository.UserRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  private final UserRepository userRepository;

  UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public List<User> getAllUser() {
    return userRepository.findAll();
  }
}
