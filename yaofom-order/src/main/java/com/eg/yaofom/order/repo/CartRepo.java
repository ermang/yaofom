package com.eg.yaofom.order.repo;

import com.eg.yaofom.order.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepo extends JpaRepository<Cart, Long> {

    List<Cart> findAllByUserId(Long userId);
}


