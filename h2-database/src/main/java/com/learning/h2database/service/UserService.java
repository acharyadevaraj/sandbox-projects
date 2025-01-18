package com.learning.h2database.service;


import com.learning.h2database.entity.UserMaster;

import java.util.List;

public interface UserService {
    public UserMaster saveUser(UserMaster userObj);

    public List<UserMaster> getUserList();

}
