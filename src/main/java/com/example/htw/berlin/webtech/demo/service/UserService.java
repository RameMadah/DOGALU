package com.example.htw.berlin.webtech.demo.service;

import com.example.htw.berlin.webtech.demo.persistence.UserEntity;
import com.example.htw.berlin.webtech.demo.persistence.UserRepository;
import com.example.htw.berlin.webtech.demo.web.api.User;
import com.example.htw.berlin.webtech.demo.web.api.UserCreateRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository usersRepository;

    public UserService(UserRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

//******************************************************************************
    //************************************************************

    public List<User> findAll (){
        List<UserEntity> users = usersRepository.findAll();
        return users.stream().map(this::entityToUser).collect(Collectors.toList());
    }


    public User create(UserCreateRequest request){
         var userEntity = new UserEntity(request.getFirstname(),request.getLastname(),request.getEmail());
         userEntity = usersRepository.save(userEntity);
        return entityToUser(userEntity);

    }



    public User entityToUser(UserEntity userEntity){
      return new User (
                userEntity.getId(),
                userEntity.getFirstname(),
                userEntity.getLastname(),
                userEntity.getEmail());

    }


}
