package com.mgr.pickMeCar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mgr.pickMeCar.db.model.Track;
import com.mgr.pickMeCar.db.model.User;
import com.mgr.pickMeCar.db.repository.TrackRepository;
import com.mgr.pickMeCar.db.repository.UserRepository;

@Service
public class TrackServiceImpl implements TrackService {
	@Autowired
	private TrackRepository trackRepository;

	@Override
	public List<Track> list() {
		return (List<Track>) trackRepository.findAll();
	}

	@Override
	public Track get(int id) {
		return trackRepository.findOne(id);
	}

	@Override
	public Track saveOrUpdate(Track track) {
		return trackRepository.save(track);

	}

	@Override
	public void delete(int id) {
		trackRepository.delete(id);

	}

	@Override
	public List<Track> findByFromPlace(String fromPlace) {
		
		return trackRepository.findByFromPlace(fromPlace);
	}

	@Override
	public List<Track> findByFromPlaceAndToPlace(String fromPlace, String toPlace) {
		return trackRepository.findByFromPlaceAndToPlace(fromPlace,toPlace);
	}

	@Override
	public List<Track> findByToPlace(String toPlace) {
		// TODO Auto-generated method stub
		return trackRepository.findByToPlace(toPlace);
	}

	@Override
	public List<Track> findByStartingDate(String startingDate) {
		// TODO Auto-generated method stub
		return trackRepository.findByStartingDate(startingDate);
	}

	@Override
	public List<Track> findByFromPlaceAndStartingDate(String fromPlace, String startingDate) {
		// TODO Auto-generated method stub
		return trackRepository.findByFromPlaceAndStartingDate(fromPlace, startingDate);
	}

	@Override
	public List<Track> findByStartingDateAndToPlace(String startingDate, String toPlace) {
		// TODO Auto-generated method stub
		return trackRepository.findByStartingDateAndToPlace(startingDate, toPlace);
	}

	@Override
	public List<Track> findByFromPlaceAndToPlaceAndStartingDate(String fromPlace, String toPlace, String startingDate) {
		// TODO Auto-generated method stub
		return trackRepository.findByFromPlaceAndToPlaceAndStartingDate(fromPlace, toPlace, startingDate);
	}

}
