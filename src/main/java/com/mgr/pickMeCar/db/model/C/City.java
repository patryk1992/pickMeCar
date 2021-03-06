package com.mgr.pickMeCar.db.model.C;
// Generated 2016-03-07 13:22:21 by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;

/**
 * City generated by hbm2java
 */
public class City implements java.io.Serializable {

	private Integer id;
	private String name;
	private double latitude;
	private double longitude;
	private Set users = new HashSet(0);
	private Set throughs = new HashSet(0);

	public City() {
	}

	public City(String name, double latitude, double longitude) {
		this.name = name;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public City(String name, double latitude, double longitude, Set users, Set throughs) {
		this.name = name;
		this.latitude = latitude;
		this.longitude = longitude;
		this.users = users;
		this.throughs = throughs;
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

	public double getLatitude() {
		return this.latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return this.longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public Set getUsers() {
		return this.users;
	}

	public void setUsers(Set users) {
		this.users = users;
	}

	public Set getThroughs() {
		return this.throughs;
	}

	public void setThroughs(Set throughs) {
		this.throughs = throughs;
	}

}
