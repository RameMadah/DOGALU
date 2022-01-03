package com.example.htw.berlin.webtech.demo.service;

import com.example.htw.berlin.webtech.demo.persistence.UserEntity;
import com.example.htw.berlin.webtech.demo.persistence.UserRepository;
import com.example.htw.berlin.webtech.demo.web.api.User;
import com.example.htw.berlin.webtech.demo.web.api.UserCreateRequest;
import org.springframework.http.ResponseEntity;
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


    public User findUserbyId(int id){
        var userentity = usersRepository.findById(id);
        return userentity.map(this::entityToUser).orElse(null);
    }

    public User update(int id , UserCreateRequest request){
        var userEntityOptional = usersRepository.findById(id);
        if(userEntityOptional.isEmpty()){
            return null;
        }
       var userEntity = userEntityOptional.get();
        userEntity.setFirstname(request.getFirstname());
        userEntity.setLastname(request.getLastname());
        userEntity.setEmail(request.getEmail());
        userEntity.setEmail(request.getPassword());
        usersRepository.save(userEntity);

        return entityToUser(userEntity);
    }

    public boolean deleteById(int id){
        if (!usersRepository.existsById(id)){
            return false;
        }
        usersRepository.existsById(id);
        return true;
    }

    public User create(UserCreateRequest request){
         var userEntity = new UserEntity(request.getFirstname(),request.getLastname(),request.getEmail(), request.getPassword());
         userEntity = usersRepository.save(userEntity);
        return entityToUser(userEntity);

    }



    public User entityToUser(UserEntity userEntity){
      return new User (
                userEntity.getId(),
                userEntity.getFirstname(),
                userEntity.getLastname(),
                userEntity.getEmail(),
              userEntity.getPassword());

    }


}
