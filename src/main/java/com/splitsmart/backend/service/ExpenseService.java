package com.splitsmart.backend.service;

import com.splitsmart.backend.model.User;
import com.splitsmart.backend.model.Group;
import com.splitsmart.backend.model.GroupMemberId;
import com.splitsmart.backend.model.Expense;
import com.splitsmart.backend.repository.ExpenseRepository;
import com.splitsmart.backend.repository.GroupRepository;
import com.splitsmart.backend.repository.GroupMemberRepository;
import com.splitsmart.backend.repository.UserRepository;
import java.util.Optional;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ExpenseService {
    // Gives the service access to the database
    private final ExpenseRepository expenseRepository;
    private final UserRepository userRepository;
    private final GroupRepository groupRepository;
    private final GroupMemberRepository groupMemberRepository;

    public ExpenseService(ExpenseRepository expenseRepository, UserRepository userRepository, GroupRepository groupRepository, GroupMemberRepository groupMemberRepository){
        this.expenseRepository = expenseRepository;
        this.userRepository = userRepository;
        this.groupRepository = groupRepository;
        this.groupMemberRepository = groupMemberRepository; 
    }
    public Expense createExpense(Expense expense) {
       Integer payerId = expense.getPaidBy().getId(); 
       Optional<User> payer = userRepository.findById(payerId);
       if (payer.isEmpty()) {
            throw new IllegalArgumentException("Payer does not exist.");
       }

       Integer groupId = expense.getGroup().getId();
       Optional<Group> group = groupRepository.findById(groupId);
       if(group.isEmpty()){
          throw new IllegalArgumentException("Group does not exist.");
       }
       // To check if GroupMember row (playerId, groupId) exist
       GroupMemberId membershipId = new GroupMemberId(payerId, groupId);
       boolean isMember = groupMemberRepository.existsById(membershipId); 
       if (!isMember) {
            throw new IllegalArgumentException("Payer is not a member of this group.");
       }
       return expenseRepository.save(expense);
    }
    public List<Expense> getAllExpenses(){
        return expenseRepository.findAll();
    }    
    public Optional<Expense> getExpenseById(Integer id){
      return expenseRepository.findById(id);
    }
    
}
