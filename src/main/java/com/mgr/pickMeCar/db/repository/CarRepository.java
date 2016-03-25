package com.mgr.pickMeCar.db.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.mgr.pickMeCar.db.model.Car;

@RepositoryRestResource(collectionResourceRel = "car", path = "car")
public interface CarRepository extends PagingAndSortingRepository<Car, Integer> {

	

}