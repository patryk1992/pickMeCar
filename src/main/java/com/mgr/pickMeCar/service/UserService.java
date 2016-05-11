package com.mgr.pickMeCar.service;

import java.util.List;

import com.mgr.pickMeCar.db.model.User;

public interface UserService {
	public List<User> list();

	public User get(int id);

	public User saveOrUpdate(User user);

	public void delete(int id);
}
