package com.learning.postgresconfig.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao{

	@PersistenceContext(unitName = "primaryUnit")
	protected EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<String> getUserNameList() {
		try {
			return entityManager.createNativeQuery("select user_name from bsmartframework.usm_usermaster").getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
