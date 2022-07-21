package com.challenge.app.coupon.domain.model;

import javax.persistence.*;

@Entity
@Table(name = "register_item")
public class RegisterItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    public RegisterItem(Long id, String itemId, Long counting) {
        this.id = id;
        this.itemId = itemId;
        this.counting = counting;
    }

    @Column(name = "item_id")
    private String itemId;

    @Column(name = "counting")
    private Long counting;

    public String getItemId() {
        return itemId;
    }

    public RegisterItem(String itemId, Long counting) {
        this.itemId = itemId;
        this.counting = counting;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public RegisterItem() {
    }

    public Long getCounting() {
        return counting;
    }

    public void setCounting(Long counting) {
        this.counting = counting;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
