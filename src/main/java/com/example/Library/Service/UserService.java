package com.example.Library.Service;

import com.example.Library.Entity.User;
import com.example.Library.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    UserService(UserRepository userRepository){
        this.userRepository= userRepository;
    }


    public List<User> getAllUser(){
        return userRepository.findAll();
    }

}
