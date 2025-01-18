package com.learning.postgresconfig.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.postgresconfig.dao.UserDao;

@Service
public class UserSeriveImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Override
	public List<String> getUserNameList() {
		return userDao.getUserNameList();
	}
}
