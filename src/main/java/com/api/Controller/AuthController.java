package com.api.Controller;


import com.api.Entity.Role;
import com.api.Entity.User;
import com.api.dto.SignUpDto;
import com.api.repository.RoleRepository;
import com.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;


    @Autowired
    private PasswordEncoder passwordEncoder;


    @Autowired
    private RoleRepository roleRepository;
    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody SignUpDto signUpDto){

        // add check userName is extis or not in database

        if(userRepository.existsByUsername(signUpDto.getUsername())){
          return   new ResponseEntity<>("Username is already Taken!!" , HttpStatus.BAD_REQUEST);
        }

        // add check Email is extis or not in database

        if(userRepository.existsByEmail(signUpDto.getEmail())){
          return   new ResponseEntity<>("Email is already Taken!!" , HttpStatus.BAD_REQUEST);
        }

        // create User object and save the data into database

        User user = new User();
        user.setName(signUpDto.getName());
        user.setUsername(signUpDto.getUsername());
        user.setEmail(signUpDto.getEmail());
        user.setPassword(passwordEncoder.encode(signUpDto.getPassword()));

        Role roles = roleRepository.findByName(signUpDto.getRoleType()).get();

        // convert role object to  set
        user.setRoles(Collections.singleton(roles));



        userRepository.save(user);

        return new ResponseEntity<>("User Register Succesfully!!" , HttpStatus.OK);
    }
}
