package com.mgr.pickMeCar.db.dao;

import java.util.List;

import com.mgr.pickMeCar.db.model.Car;

public interface CarDAO {
	public List<Car> list();

	public Car get(int id);

	public void saveOrUpdate(Car car);

	public void delete(int id);
}
