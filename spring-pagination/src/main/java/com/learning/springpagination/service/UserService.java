package com.learning.springpagination.service;


import com.learning.springpagination.entity.UserMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {
    public UserMaster saveUser(UserMaster userObj);

    public Page<UserMaster> getUserList(Pageable pageable);

}
