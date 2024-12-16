package com.example.splitwise.demo.repo;

import com.example.splitwise.demo.models.UserExpense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserExpenseRepository extends JpaRepository<UserExpense, Integer> {
}
