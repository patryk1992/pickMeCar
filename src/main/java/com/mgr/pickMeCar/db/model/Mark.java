package com.mgr.pickMeCar.db.model;
// Generated 2016-03-14 15:22:54 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * Mark generated by hbm2java
 */
@Entity
@Table(name = "mark", catalog = "drive_db")
public class Mark implements java.io.Serializable {

	private Integer id;
	
	private User user;
	private User ratingUser;
	private int rate;
	private String description;

	public Mark() {
	}

	public Mark(User user,User ratingUser, int rate) {
		this.user = user;
		this.rate = rate;
		this.ratingUser= ratingUser;
	}

	public Mark(User user,User ratingUser, int rate, String description) {
		this.user = user;
		this.rate = rate;
		this.description = description;
		this.ratingUser = ratingUser;
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
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idUser", nullable = false)
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idRatingUser")
	public User getRatingUser() {
		return ratingUser;
	}

	public void setRatingUser(User ratingUser) {
		this.ratingUser = ratingUser;
	}


	@Column(name = "rate")
	public int getRate() {
		return this.rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	@Column(name = "description")
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
