package com.mgr.pickMeCar.db.dao;

import java.util.List;

import com.mgr.pickMeCar.db.model.UserGroup;

public interface UserGroupDAO {
	public List<UserGroup> list();

	public UserGroup get(int id);

	public void saveOrUpdate(UserGroup userGroup);

	public void delete(int id);
}
