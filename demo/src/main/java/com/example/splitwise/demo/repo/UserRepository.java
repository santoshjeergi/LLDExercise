package com.example.splitwise.demo.repo;

import com.example.splitwise.demo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  UserRepository extends JpaRepository<User, Integer> {

}
