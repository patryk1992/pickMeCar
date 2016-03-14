package com.mgr.pickMeCar.db.model;
// Generated 2016-03-14 13:58:12 by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Track generated by hbm2java
 */
@Entity
@Table(name = "track", catalog = "drive_db")
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

	public Track(String fromPlace, String toPlace, Integer startingPlace, String startingTime, Integer price,
			Set throughs, Set userTracks) {
		this.fromPlace = fromPlace;
		this.toPlace = toPlace;
		this.startingPlace = startingPlace;
		this.startingTime = startingTime;
		this.price = price;
		this.throughs = throughs;
		this.userTracks = userTracks;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "fromPlace", length = 45)
	public String getFromPlace() {
		return this.fromPlace;
	}

	public void setFromPlace(String fromPlace) {
		this.fromPlace = fromPlace;
	}

	@Column(name = "toPlace", length = 45)
	public String getToPlace() {
		return this.toPlace;
	}

	public void setToPlace(String toPlace) {
		this.toPlace = toPlace;
	}

	@Column(name = "startingPlace")
	public Integer getStartingPlace() {
		return this.startingPlace;
	}

	public void setStartingPlace(Integer startingPlace) {
		this.startingPlace = startingPlace;
	}

	@Column(name = "startingTime", length = 45)
	public String getStartingTime() {
		return this.startingTime;
	}

	public void setStartingTime(String startingTime) {
		this.startingTime = startingTime;
	}

	@Column(name = "price")
	public Integer getPrice() {
		return this.price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "track")
	public Set getThroughs() {
		return this.throughs;
	}

	public void setThroughs(Set throughs) {
		this.throughs = throughs;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "track")
	public Set getUserTracks() {
		return this.userTracks;
	}

	public void setUserTracks(Set userTracks) {
		this.userTracks = userTracks;
	}

}
