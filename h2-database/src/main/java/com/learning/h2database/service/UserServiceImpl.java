package com.learning.h2database.service;

import com.learning.h2database.entity.UserMaster;
import com.learning.h2database.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepo;

    public UserMaster saveUser(UserMaster userObj) {
        return userRepo.save(userObj);
    }

    public List<UserMaster> getUserList() {
        return userRepo.findAll();
    }
}
