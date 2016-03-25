package com.mgr.pickMeCar.db.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.mgr.pickMeCar.db.model.Through;

@RepositoryRestResource(collectionResourceRel = "through", path = "through")
public interface ThroughRepository extends PagingAndSortingRepository<Through, Integer> {

	

}