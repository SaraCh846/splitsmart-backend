package com.splitsmart.backend.repository;

import com.splitsmart.backend.model.ExpenseParticipant;
import com.splitsmart.backend.model.ExpenseParticipantId;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseParticipantRepository extends JpaRepository<ExpenseParticipant, ExpenseParticipantId> {
    List<ExpenseParticipant> findByExpense_Id(Integer expenseId);
}