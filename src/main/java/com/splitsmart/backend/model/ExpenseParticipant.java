package com.splitsmart.backend.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

import java.math.BigDecimal;

@Entity
@Table(name = "expense_participants")
public class ExpenseParticipant {

    @EmbeddedId
    private ExpenseParticipantId id;

    @ManyToOne
    @MapsId("expenseId")
    @JoinColumn(name = "expense_id", nullable = false)
    private Expense expense;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal shareAmount;

    public ExpenseParticipant() {
    }

    public ExpenseParticipant(Expense expense, User user, BigDecimal shareAmount) {
        this.expense = expense;
        this.user = user;
        this.shareAmount = shareAmount;
        this.id = new ExpenseParticipantId(expense.getId(), user.getId());
    }

    public ExpenseParticipantId getId() {
        return id;
    }

    public Expense getExpense() {
        return expense;
    }

    public User getUser() {
        return user;
    }

    public BigDecimal getShareAmount() {
        return shareAmount;
    }

    public void setShareAmount(BigDecimal shareAmount) {
        this.shareAmount = shareAmount;
    }
}