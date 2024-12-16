package com.example.splitwise.demo.dto;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class UserRequestCreateDto {

    String email;
    String username;
    String phone;
}
