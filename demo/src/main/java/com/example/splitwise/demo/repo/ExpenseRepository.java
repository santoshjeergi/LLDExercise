package com.example.splitwise.demo.repo;

import com.example.splitwise.demo.models.Expenses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseRepository extends JpaRepository<Expenses, Integer> {
}
