package com.eg.yaofom.user.repo;

import com.eg.yaofom.user.entity.YaofomUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface YaofomUserRepo extends JpaRepository<YaofomUser, Long> {


    YaofomUser findByUsername(String username);
}


