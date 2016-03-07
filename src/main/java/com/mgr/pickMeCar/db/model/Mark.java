package com.mgr.pickMeCar.db.model;
// Generated 2016-03-07 13:22:21 by Hibernate Tools 3.4.0.CR1

/**
 * Mark generated by hbm2java
 */
public class Mark implements java.io.Serializable {

	private Integer id;
	private User user;
	private int rate;
	private String description;

	public Mark() {
	}

	public Mark(User user, int rate) {
		this.user = user;
		this.rate = rate;
	}

	public Mark(User user, int rate, String description) {
		this.user = user;
		this.rate = rate;
		this.description = description;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getRate() {
		return this.rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}