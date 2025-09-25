package com.eg.yaofom.order.repo;

import com.eg.yaofom.order.entity.Cart;
import com.eg.yaofom.order.entity.YaofomOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface YaofomOrderRepo extends JpaRepository<YaofomOrder, Long> {


}


