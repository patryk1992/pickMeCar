package com.mgr.pickMeCar.service;

import java.util.List;

import com.mgr.pickMeCar.db.model.Track;
import com.mgr.pickMeCar.db.model.User;

public interface TrackService {
	public List<Track> list();

	public Track get(int id);

	public Track saveOrUpdate(Track track);

	public void delete(int id);
	
	List<Track> findByFromPlace(String fromPlace);
	List<Track> findByToPlace(String toPlace);
	List<Track> findByStartingDate(String startingDate);
	List<Track> findByFromPlaceAndToPlace(String fromPlace,String toPlace);
	List<Track> findByFromPlaceAndStartingDate(String fromPlace,String startingDate);
	List<Track> findByStartingDateAndToPlace(String startingDate,String toPlace);
	List<Track> findByFromPlaceAndToPlaceAndStartingDate(String fromPlace,String toPlace,String startingDate);
}
