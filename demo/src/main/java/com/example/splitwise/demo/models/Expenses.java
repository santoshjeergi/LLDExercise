package com.example.splitwise.demo.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Expenses extends BaseModel{

    private String name;
    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;

    private Double totalAmount;
  //  @OneToMany (fetch = FetchType.EAGER, mappedBy = "expenses")

 @OneToMany(fetch = FetchType.EAGER)
    private List<UserExpense> userExpenseList;
}

/*T_Expense




T_UserExpense FK ExpId

*/

/*
1 m

E - g
1   1
m    1
* */
