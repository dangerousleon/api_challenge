package com.challenge.app.coupon.common.dto;

import java.util.List;

public class CouponResponse {
    private List<String> item_ids;
    private Double total;

    public CouponResponse(List<String> item_ids, Double total) {
        this.item_ids = item_ids;
        this.total = total;
    }

    public List<String> getItem_ids() {
        return item_ids;
    }

    public void setItem_ids(List<String> item_ids) {
        this.item_ids = item_ids;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
