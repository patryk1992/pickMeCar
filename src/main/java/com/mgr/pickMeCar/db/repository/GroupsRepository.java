package com.mgr.pickMeCar.db.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.mgr.pickMeCar.db.model.Groups;

@RepositoryRestResource(collectionResourceRel = "groups", path = "groups")
public interface GroupsRepository extends PagingAndSortingRepository<Groups, Integer> {

	List<Groups> findByName(@Param("name") String name);

}