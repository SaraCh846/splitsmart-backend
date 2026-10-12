package com.splitsmart.backend.model;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ExpenseParticipantId implements Serializable {

    private Integer expenseId;
    private Integer userId;

    public ExpenseParticipantId() {
    }

    public ExpenseParticipantId(Integer expenseId, Integer userId) {
        this.expenseId = expenseId;
        this.userId = userId;
    }

    public Integer getExpenseId() {
        return expenseId;
    }

    public Integer getUserId() {
        return userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof ExpenseParticipantId)) {
            return false;
        }

        ExpenseParticipantId that = (ExpenseParticipantId) o;

        return Objects.equals(expenseId, that.expenseId)
                && Objects.equals(userId, that.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(expenseId, userId);
    }
}