package com.example.splitwise.demo.models;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity(name = "splitwiseuser")
@Data
public class User extends BaseModel{
   private String name;
   private String email;
   private String phone;
}
