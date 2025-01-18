package com.learning.springpagination.repository;

import com.learning.springpagination.entity.UserMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserMaster, Long> {

}
