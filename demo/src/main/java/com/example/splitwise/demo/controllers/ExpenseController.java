package com.example.splitwise.demo.controllers;

import com.example.splitwise.demo.dto.ExpenseRequestDto;
import com.example.splitwise.demo.dto.ExpenseResponseDto;
import com.example.splitwise.demo.models.Expenses;
import com.example.splitwise.demo.service.ExpenseService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("expense")
public class ExpenseController {

    private ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService){
        this.expenseService = expenseService;
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody ExpenseResponseDto createExpense(@RequestBody ExpenseRequestDto expenseRequestDto) {
        ExpenseResponseDto expenseResponseDto = new ExpenseResponseDto();
       Expenses expenses =  expenseService.createExpense(expenseRequestDto.getName(), expenseRequestDto.getUserExpenses(), expenseRequestDto.getTotalAmount(),
               expenseRequestDto.getGroupId());

        expenseResponseDto.setExpenses(expenses);
        expenseResponseDto.setResponseStatus(com.example.splitwise.demo.dto.ResponseStatus.SUCCESS);
        return expenseResponseDto;
    }


}
