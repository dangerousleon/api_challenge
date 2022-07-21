package com.challenge.app.coupon.controller;

import com.challenge.app.coupon.common.dto.CouponRequest;
import com.challenge.app.coupon.common.dto.CouponResponse;
import com.challenge.app.coupon.common.dto.ItemCounting;
import com.challenge.app.coupon.core.manager.CouponManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CouponController {

    @Autowired
    private CouponManager couponManager;

    @PostMapping("/coupon")
    public ResponseEntity<CouponResponse> postCoupon(@RequestBody CouponRequest request) {
        CouponResponse response = couponManager.postCoupon(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/coupon/stats")
    public ResponseEntity<List<ItemCounting>> getCouponStats(){
        List <ItemCounting> listResponse =couponManager.getCouponStats();
        return ResponseEntity.ok(listResponse);
    }
}