package com.example.splitwise.demo.models;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class UserExpense extends BaseModel{

    private String name;
    private Integer userId;

    private Double amountOwed;
    private Double amounttoRecv;

}
