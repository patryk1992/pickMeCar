package com.mgr.pickMeCar.db.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.mgr.pickMeCar.db.model.City;

@RepositoryRestResource(collectionResourceRel = "city", path = "city")
public interface CityRepository extends PagingAndSortingRepository<City, Integer> {

	List<City> findByName(@Param("name") String name);

}