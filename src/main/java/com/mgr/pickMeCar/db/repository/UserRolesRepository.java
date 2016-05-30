package com.mgr.pickMeCar.db.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.mgr.pickMeCar.db.model.UserRole;

@RepositoryRestResource(collectionResourceRel = "userRoles", path = "userRoles")
public interface UserRolesRepository extends PagingAndSortingRepository<UserRole, Integer> {

	@Query("select a.role from UserRole a, User b where b.userName=?1 and a.id=b.id")
    public List<String> findRoleByName(String username);

}