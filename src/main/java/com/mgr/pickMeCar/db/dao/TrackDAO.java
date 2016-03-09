package com.mgr.pickMeCar.db.dao;

import java.util.List;

import com.mgr.pickMeCar.db.model.Track;

public interface TrackDAO {
	public List<Track> list();

	public Track get(int id);

	public void saveOrUpdate(Track track);

	public void delete(int id);
}
