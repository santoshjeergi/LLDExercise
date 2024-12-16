package com.example.splitwise.demo.dto;

import com.example.splitwise.demo.models.User;
import lombok.Data;

import java.util.List;

@Data
public class GroupCreateRequestDto {

    private String name;

    private List<Integer> userIdList;
}
