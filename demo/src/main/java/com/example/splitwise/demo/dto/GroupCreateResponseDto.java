package com.example.splitwise.demo.dto;

import com.example.splitwise.demo.models.Group;
import lombok.Data;

@Data
public class GroupCreateResponseDto {

   private Group group;
   private ResponseStatus status;

}
