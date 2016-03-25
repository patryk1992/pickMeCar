package com.mgr.pickMeCar.db.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.mgr.pickMeCar.db.model.Track;

@RepositoryRestResource(collectionResourceRel = "track", path = "track")
public interface TrackRepository extends PagingAndSortingRepository<Track, Integer> {

	

}