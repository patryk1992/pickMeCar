package com.mgr.pickMeCar.db.model.C;
// Generated 2016-03-07 13:22:21 by Hibernate Tools 3.4.0.CR1

/**
 * Through generated by hbm2java
 */
public class Through implements java.io.Serializable {

	private Integer id;
	private City city;
	private Track track;
	private Double price;

	public Through() {
	}

	public Through(City city, Track track) {
		this.city = city;
		this.track = track;
	}

	public Through(City city, Track track, Double price) {
		this.city = city;
		this.track = track;
		this.price = price;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public City getCity() {
		return this.city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public Track getTrack() {
		return this.track;
	}

	public void setTrack(Track track) {
		this.track = track;
	}

	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

}
