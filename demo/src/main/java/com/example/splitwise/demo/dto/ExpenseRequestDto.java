package com.example.splitwise.demo.dto;

import lombok.Data;

import java.util.Map;

@Data
public class ExpenseRequestDto {

    private String name;
    private Map<Integer, Double> userExpenses;
    private Integer groupId;
    private Double totalAmount;
}
