package com.example.splitwise.demo.dto;

import com.example.splitwise.demo.models.Expenses;
import lombok.Data;

@Data
public class ExpenseResponseDto {


    private ResponseStatus responseStatus;
    private Expenses expenses;
}
