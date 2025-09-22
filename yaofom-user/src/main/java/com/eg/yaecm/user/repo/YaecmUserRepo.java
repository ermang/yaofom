package com.eg.yaecm.user.repo;

import com.eg.yaecm.user.entity.YaecmUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface YaecmUserRepo extends JpaRepository<YaecmUser, Long> {


    YaecmUser findByUsername(String username);
}


