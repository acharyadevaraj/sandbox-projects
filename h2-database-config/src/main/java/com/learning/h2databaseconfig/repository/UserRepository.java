package com.learning.h2databaseconfig.repository;

import com.learning.h2databaseconfig.entity.UserMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserMaster, Long> {

}
