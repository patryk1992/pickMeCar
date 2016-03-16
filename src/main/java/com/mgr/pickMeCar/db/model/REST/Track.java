package com.mgr.pickMeCar.db.model.REST;
// Generated 2016-03-07 13:22:21 by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;

/**
 * Track generated by hbm2java
 */
public class Track implements java.io.Serializable {

	private Integer id;
	private String fromPlace;
	private String toPlace;
	private Integer startingPlace;
	private String startingTime;
	private Integer price;
	private Set throughs = new HashSet(0);
	private Set userTracks = new HashSet(0);

	public Track() {
	}

	public Track(String fromPlace, String toPlace, Integer startingPlace, String startingTime, Integer price, Set throughs,
			Set userTracks) {
		this.fromPlace = fromPlace;
		this.toPlace = toPlace;
		this.startingPlace = startingPlace;
		this.startingTime = startingTime;
		this.price = price;
		this.throughs = throughs;
		this.userTracks = userTracks;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}	

	public String getFromPlace() {
		return fromPlace;
	}

	public void setFromPlace(String fromPlace) {
		this.fromPlace = fromPlace;
	}

	public String getToPlace() {
		return toPlace;
	}

	public void setToPlace(String toPlace) {
		this.toPlace = toPlace;
	}

	public Integer getStartingPlace() {
		return this.startingPlace;
	}

	public void setStartingPlace(Integer startingPlace) {
		this.startingPlace = startingPlace;
	}

	public String getStartingTime() {
		return this.startingTime;
	}

	public void setStartingTime(String startingTime) {
		this.startingTime = startingTime;
	}

	public Integer getPrice() {
		return this.price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Set getThroughs() {
		return this.throughs;
	}

	public void setThroughs(Set throughs) {
		this.throughs = throughs;
	}

	public Set getUserTracks() {
		return this.userTracks;
	}

	public void setUserTracks(Set userTracks) {
		this.userTracks = userTracks;
	}

}
