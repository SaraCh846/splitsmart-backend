package com.splitsmart.backend.controller;

import com.splitsmart.backend.model.Expense;
import com.splitsmart.backend.service.ExpenseService;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/expenses")
public class ExpenseController {
    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService){
       this.expenseService = expenseService;
    }
    
    @GetMapping
    public List<Expense> getAllExpenses(){
        return expenseService.getAllExpenses();
    }
    
    @GetMapping("/{id}")
    public Optional<Expense> getExpenseById(@PathVariable Integer id){
       return  expenseService.getExpenseById(id);
    }

    @PostMapping 
    public Expense postExpense(@RequestBody Expense expense){
        return expenseService.createExpense(expense);
    }
}
