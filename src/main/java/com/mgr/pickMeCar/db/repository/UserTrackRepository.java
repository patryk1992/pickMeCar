package com.mgr.pickMeCar.db.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.mgr.pickMeCar.db.model.UserTrack;

@RepositoryRestResource(collectionResourceRel = "userTrack", path = "userTrack")
public interface UserTrackRepository extends PagingAndSortingRepository<UserTrack, Integer> {

	

}