package com.challenge.app.coupon.common.dto;

public class ItemCounting {

    private String id;
    private Long quantity;

    public ItemCounting() {
    }

    public ItemCounting(String id, Long quantity) {
        this.id = id;
        this.quantity = quantity;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
