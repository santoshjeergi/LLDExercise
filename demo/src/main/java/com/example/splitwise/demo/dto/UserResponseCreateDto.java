package com.example.splitwise.demo.dto;

import com.example.splitwise.demo.models.User;
import lombok.Data;

@Data
public class UserResponseCreateDto {

    ResponseStatus responseStatus;
    User user;
}