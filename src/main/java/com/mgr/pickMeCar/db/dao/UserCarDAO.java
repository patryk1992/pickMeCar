package com.mgr.pickMeCar.db.dao;

import java.util.List;

import com.mgr.pickMeCar.db.model.UserCar;

public interface UserCarDAO {
	public List<UserCar> list();

	public UserCar get(int id);

	public void saveOrUpdate(UserCar userCar);

	public void delete(int id);
}
