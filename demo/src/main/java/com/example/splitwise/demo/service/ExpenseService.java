package com.example.splitwise.demo.service;

import com.example.splitwise.demo.models.Expenses;
import com.example.splitwise.demo.models.Group;
import com.example.splitwise.demo.models.User;
import com.example.splitwise.demo.models.UserExpense;
import com.example.splitwise.demo.repo.ExpenseRepository;
import com.example.splitwise.demo.repo.GroupRepository;
import com.example.splitwise.demo.repo.UserExpenseRepository;
import com.example.splitwise.demo.repo.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ExpenseService {
    private GroupRepository groupRepository;
    private UserRepository userRepository;
    private ExpenseRepository expenseRepository;
    private UserExpenseRepository userExpenseRepository;

    public ExpenseService(GroupRepository groupRepository, UserRepository userRepository, ExpenseRepository expenseRepository, UserExpenseRepository userExpenseRepository){
        this.groupRepository = groupRepository;
        this.userRepository = userRepository;
        this.expenseRepository = expenseRepository;
        this.userExpenseRepository = userExpenseRepository;
    }

   public Expenses createExpense(String name, Map<Integer, Double> userIdExpenseMapping,Double totalAmount,  Integer groupId) {

        Expenses expenses  = new Expenses();
       Optional<Group> optionalGroup  = groupRepository.findById(groupId);
       if(optionalGroup.isEmpty()){
           System.out.println("Incorrect groupId. throw exception");
           throw  new RuntimeException("Incorrect group");
        //   return null;
       }
        expenses.setGroup(optionalGroup.get());
       expenses.setName(name);

       List<User> userList =userRepository.findAllById(userIdExpenseMapping.keySet());

       List<UserExpense> userExpenseList = new ArrayList<>();

       for(User user: userList) {
           UserExpense userExpense = new UserExpense();
           userExpense.setUserId(user.getId());
           userExpense.setAmountOwed(userIdExpenseMapping.get(user.getId()));
           userExpense.setAmounttoRecv(0.0);
           userExpenseRepository.save(userExpense);
           userExpenseList.add(userExpense);
       }
       expenses.setUserExpenseList(userExpenseList); //should we save this userExpense in repo- Bro.
       expenseRepository.save(expenses);
       return expenses;
   }
}
