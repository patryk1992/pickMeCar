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

}
