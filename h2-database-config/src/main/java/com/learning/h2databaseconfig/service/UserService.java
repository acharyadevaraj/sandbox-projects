package com.learning.h2databaseconfig.service;


import com.learning.h2databaseconfig.entity.UserMaster;

import java.util.List;

public interface UserService {
    public UserMaster saveUser(UserMaster userObj);

    public List<UserMaster> getUserList();

}
