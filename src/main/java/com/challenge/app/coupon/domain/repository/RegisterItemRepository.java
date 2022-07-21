package com.challenge.app.coupon.domain.repository;

import com.challenge.app.coupon.domain.model.RegisterItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RegisterItemRepository extends JpaRepository<RegisterItem, Integer> {
    Optional<RegisterItem> findByItemId(String itemId);


    @Query(value = "select * from register_item  order by counting DESC limit 5", nativeQuery = true)
    List<RegisterItem> getRegisterItemOrderByCountingDesc();

}