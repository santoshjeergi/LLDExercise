package com.example.splitwise.demo.controllers;

import com.example.splitwise.demo.dto.UserRequestCreateDto;
import com.example.splitwise.demo.dto.UserResponseCreateDto;
import com.example.splitwise.demo.models.User;
import com.example.splitwise.demo.repo.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/splitwiseuser")
public class UserController {

   private final UserRepository userRepository;

   public UserController(UserRepository userRepository) {

        this.userRepository = userRepository;

    }
@PostMapping("/createuser")
@ResponseStatus(HttpStatus.CREATED)
  public @ResponseBody UserResponseCreateDto createuser(@RequestBody UserRequestCreateDto userRequestCreateDto) {

    System.out.println("Entering the user creation");
    User user = new User();
    user.setEmail(userRequestCreateDto.getEmail());
    user.setName(userRequestCreateDto.getUsername());
    System.out.println("Request for creation of user:"+ user.getEmail() +" :"+ user.getName());
    UserResponseCreateDto userResponseCreateDto = new UserResponseCreateDto();

    userResponseCreateDto.setUser(userRepository.save(user));
    userResponseCreateDto.setResponseStatus(com.example.splitwise.demo.dto.ResponseStatus.SUCCESS);
    return userResponseCreateDto;
    }
    @GetMapping("/getusers")
    public List<User> getallUsers() {
            return userRepository.findAll();
    }
}
