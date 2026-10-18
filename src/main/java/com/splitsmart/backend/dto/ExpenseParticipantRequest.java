package com.splitsmart.backend.dto;

import java.math.BigDecimal;

public class ExpenseParticipantRequest {

    private Integer userId;
    private BigDecimal shareAmount;

    public ExpenseParticipantRequest() {
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public BigDecimal getShareAmount() {
        return shareAmount;
    }

    public void setShareAmount(BigDecimal shareAmount) {
        this.shareAmount = shareAmount;
    }
}