package com.splitsmart.backend.service;

import com.splitsmart.backend.repository.ExpenseRepository;
import com.splitsmart.backend.repository.UserRepository;
import com.splitsmart.backend.repository.GroupMemberRepository;
import com.splitsmart.backend.model.Expense;
import com.splitsmart.backend.model.User;
import com.splitsmart.backend.model.ExpenseParticipant;
import com.splitsmart.backend.model.ExpenseParticipantId;
import com.splitsmart.backend.model.GroupMemberId;
import com.splitsmart.backend.repository.ExpenseParticipantRepository;
import java.math.BigDecimal;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.List;

@Service
public class ExpenseParticipantService {
    private final ExpenseRepository expenseRepository;
    private final UserRepository userRepository;
    private final GroupMemberRepository groupMemberRepository;
    private final ExpenseParticipantRepository expenseParticipantRepository;

    public ExpenseParticipantService(ExpenseRepository expenseRepository, UserRepository userRepository, GroupMemberRepository groupMemberRepository, ExpenseParticipantRepository expenseParticipantRepository) {
        this.expenseRepository = expenseRepository;
        this.userRepository = userRepository;
        this.groupMemberRepository = groupMemberRepository;
        this.expenseParticipantRepository = expenseParticipantRepository;
    }

    public ExpenseParticipant addParticipant(Integer userId, Integer expenseId, BigDecimal shareAmount) {

    Optional<Expense> expense = expenseRepository.findById(expenseId);
    if (expense.isEmpty()) {
        throw new IllegalArgumentException("Expense does not exist.");
    }
    Optional<User> user = userRepository.findById(userId);
    if (user.isEmpty()) {
        throw new IllegalArgumentException("User does not exist.");
    }

    if (shareAmount.compareTo(BigDecimal.ZERO) <= 0) {
        throw new IllegalArgumentException("Share amount must be greater than 0.");
    }
    Integer groupId = expense.get().getGroup().getId();
    GroupMemberId membershipId = new GroupMemberId(userId, groupId);
    boolean isMember = groupMemberRepository.existsById(membershipId);
    if (!isMember) {
        throw new IllegalArgumentException("User is not a member of this group.");
    }
    ExpenseParticipantId participantId = new ExpenseParticipantId(expenseId, userId);
    boolean isParticipant = expenseParticipantRepository.existsById(participantId);
    if (isParticipant) {
        throw new IllegalArgumentException("User is already a participant in this expense.");
    }
    
    List<ExpenseParticipant> participants = expenseParticipantRepository.findByExpense_Id(expenseId);
    BigDecimal totalShares = BigDecimal.ZERO;
    for (ExpenseParticipant p : participants) {
        totalShares = totalShares.add(p.getShareAmount());
    }
    totalShares = totalShares.add(shareAmount);
    if (totalShares.compareTo(expense.get().getAmount()) > 0) {
        throw new IllegalArgumentException("Total shares cannot exceed the expense amount.");
    }

    ExpenseParticipant participant = new ExpenseParticipant(expense.get(), user.get(), shareAmount);
    return expenseParticipantRepository.save(participant);
    }

    public List<ExpenseParticipant> getAllExpenseParticipant(Integer expenseId){
        return expenseParticipantRepository.findByExpense_Id(expenseId);
    }


}
  
