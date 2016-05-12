package com.mgr.pickMeCar.service;

import java.util.List;

import com.mgr.pickMeCar.db.model.Track;
import com.mgr.pickMeCar.db.model.User;

public interface TrackService {
	public List<Track> list();

	public Track get(int id);

	public Track saveOrUpdate(Track track);

	public void delete(int id);
}
