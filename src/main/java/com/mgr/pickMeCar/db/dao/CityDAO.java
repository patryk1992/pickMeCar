package com.mgr.pickMeCar.db.dao;

import java.util.List;

import com.mgr.pickMeCar.db.model.City;

public interface CityDAO {
	public List<City> list();

	public City get(int id);

	public void saveOrUpdate(City city);

	public void delete(int id);
}
