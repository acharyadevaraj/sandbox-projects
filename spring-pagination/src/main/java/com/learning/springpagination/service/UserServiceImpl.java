package com.learning.springpagination.service;

import com.learning.springpagination.entity.UserMaster;
import com.learning.springpagination.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepo;

    public UserMaster saveUser(UserMaster userObj) {
        return userRepo.save(userObj);
    }

    public Page<UserMaster> getUserList(Pageable pageable) {
        return userRepo.findAll(pageable);
    }
}
