package com.challenge.app.coupon.common.dto;

import java.util.List;

public class CouponRequest {
    private List<String> item_ids;
    private Double amount;

    public CouponRequest(List<String> item_ids, Double amount) {
        this.item_ids = item_ids;
        this.amount = amount;
    }

    public List<String> getItem_ids() {
        return item_ids;
    }

    public void setItem_ids(List<String> item_ids) {
        this.item_ids = item_ids;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
