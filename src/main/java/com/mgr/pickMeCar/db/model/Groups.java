package com.mgr.pickMeCar.db.model;
// Generated 2016-03-07 13:22:21 by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;

/**
 * Groups generated by hbm2java
 */
public class Groups implements java.io.Serializable {

	private Integer id;
	private String name;
	private String description;
	private Set userGroups = new HashSet(0);

	public Groups() {
	}

	public Groups(String name, String description, Set userGroups) {
		this.name = name;
		this.description = description;
		this.userGroups = userGroups;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set getUserGroups() {
		return this.userGroups;
	}

	public void setUserGroups(Set userGroups) {
		this.userGroups = userGroups;
	}

}
