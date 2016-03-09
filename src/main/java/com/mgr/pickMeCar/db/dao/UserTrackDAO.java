package com.mgr.pickMeCar.db.dao;

import java.util.List;

import com.mgr.pickMeCar.db.model.UserTrack;

public interface UserTrackDAO {
	public List<UserTrack> list();

	public UserTrack get(int id);

	public void saveOrUpdate(UserTrack userTrack);

	public void delete(int id);
}
