package com.mgr.pickMeCar.db.dao;

import java.util.List;

import com.mgr.pickMeCar.db.model.Groups;

public interface GroupsDAO {
	public List<Groups> list();

	public Groups get(int id);

	public void saveOrUpdate(Groups groups);

	public void delete(int id);
}
