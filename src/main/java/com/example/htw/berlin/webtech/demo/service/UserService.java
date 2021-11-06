package com.example.htw.berlin.webtech.demo.service;

import com.example.htw.berlin.webtech.demo.persistence.UserEntity;
import com.example.htw.berlin.webtech.demo.persistence.UserRepository;
import com.example.htw.berlin.webtech.demo.web.api.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {


    private final UserRepository usersRepository;

    public UserService(UserRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public List<User> findAll (){
 List<UserEntity> users = usersRepository.findAll();
  return users.stream().map(UserEntity ->new User (
          UserEntity.getId(),
          UserEntity.getFirstname(),
          UserEntity.getLastname(),
          UserEntity.getEmail())).collect(Collectors.toList());
    }
}
