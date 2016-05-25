package com.mgr.pickMeCar.db.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.mgr.pickMeCar.db.model.Track;

@RepositoryRestResource(collectionResourceRel = "track", path = "track")
public interface TrackRepository extends PagingAndSortingRepository<Track, Integer> {

	List<Track> findByFromPlace(String fromPlace);
	List<Track> findByToPlace(String toPlace);
	List<Track> findByStartingDate(String startingDate);
	List<Track> findByFromPlaceAndToPlace(String fromPlace,String toPlace);
	List<Track> findByFromPlaceAndStartingDate(String fromPlace,String startingDate);
	List<Track> findByStartingDateAndToPlace(String startingDate,String toPlace);
	List<Track> findByFromPlaceAndToPlaceAndStartingDate(String fromPlace,String toPlace,String startingDate);
}