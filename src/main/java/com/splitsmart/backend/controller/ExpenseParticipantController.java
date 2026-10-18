package com.splitsmart.backend.controller;

import com.splitsmart.backend.model.ExpenseParticipant;
import com.splitsmart.backend.service.ExpenseParticipantService;
import java.util.List;
import java.math.BigDecimal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.splitsmart.backend.dto.ExpenseParticipantRequest;

@RestController 
@RequestMapping("/expenses/{expenseId}/participants")
public class ExpenseParticipantController {
    private final ExpenseParticipantService expenseParticipantService;

    public ExpenseParticipantController(ExpenseParticipantService expenseParticipantService){
        this.expenseParticipantService = expenseParticipantService;
    }

    @GetMapping 
    public List<ExpenseParticipant> getAllExpenseParticipant(@PathVariable Integer expenseId){
        return expenseParticipantService.getAllExpenseParticipant(expenseId);
    }

    @PostMapping 
    public ExpenseParticipant addPart(@PathVariable Integer expenseId,  @RequestBody ExpenseParticipantRequest request){
       return expenseParticipantService.addParticipant(request.getUserId(), expenseId, request.getShareAmount());
    }

}
