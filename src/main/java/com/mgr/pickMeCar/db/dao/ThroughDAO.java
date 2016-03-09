package com.mgr.pickMeCar.db.dao;

import java.util.List;

import com.mgr.pickMeCar.db.model.Through;

public interface ThroughDAO {
	public List<Through> list();

	public Through get(int id);

	public void saveOrUpdate(Through through);

	public void delete(int id);
}
