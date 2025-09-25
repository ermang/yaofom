package com.eg.yaofom.order.repo;

import com.eg.yaofom.order.entity.OrderItem;
import com.eg.yaofom.order.entity.YaofomOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepo extends JpaRepository<OrderItem, Long> {


}


