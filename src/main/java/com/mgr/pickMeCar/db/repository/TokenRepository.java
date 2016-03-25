package com.mgr.pickMeCar.db.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.mgr.pickMeCar.db.model.Token;

@RepositoryRestResource(collectionResourceRel = "com.mgr.pickMeCar.db.model.token", path = "token")
public interface TokenRepository extends PagingAndSortingRepository<Token, Integer> {

	List<Token> findByToken(@Param("token") String token);

}