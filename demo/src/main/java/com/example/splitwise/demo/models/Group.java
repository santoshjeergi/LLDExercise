package com.example.splitwise.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Data
@Entity(name = "splitwisegroup")
public class Group extends BaseModel{
    private String name;

    @ManyToMany
    private List<User> usersList;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "group")
    private List<Expenses> expensesList;
}
