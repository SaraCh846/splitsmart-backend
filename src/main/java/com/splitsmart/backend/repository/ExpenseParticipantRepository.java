package com.splitsmart.backend.repository;

import com.splitsmart.backend.model.ExpenseParticipant;
import com.splitsmart.backend.model.ExpenseParticipantId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseParticipantRepository extends JpaRepository<ExpenseParticipant, ExpenseParticipantId> {
    
}