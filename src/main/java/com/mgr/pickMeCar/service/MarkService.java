package com.mgr.pickMeCar.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.mgr.pickMeCar.db.model.Mark;
import com.mgr.pickMeCar.db.model.User;

public interface MarkService {
	public List<Mark> list();

	public Mark get(int id);

	public Mark saveOrUpdate(Mark mark);

	public void delete(int id);
	
	
}
