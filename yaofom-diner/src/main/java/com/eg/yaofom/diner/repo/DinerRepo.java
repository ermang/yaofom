package com.eg.yaofom.diner.repo;

import com.eg.yaofom.diner.entity.Diner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DinerRepo extends JpaRepository<Diner, Long> {

    Optional<Diner> findByShopOwnerId(Long userId);
}


