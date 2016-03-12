package com.mgr.pickMeCar.db.dao;

import java.util.List;

import com.mgr.pickMeCar.db.model.Mark;

public interface MarkDAO {
	public List<Mark> list();

	public Mark get(int id);

	public void saveOrUpdate(Mark mark);

	public void delete(int id);
}
