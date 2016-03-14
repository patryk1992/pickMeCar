package com.mgr.pickMeCar.db.model;
// Generated 2016-03-14 13:58:12 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * UserGroup generated by hbm2java
 */
@Entity
@Table(name = "user_group", catalog = "drive_db")
public class UserGroup implements java.io.Serializable {

	private Integer id;
	private User user;
	private Groups groups;

	public UserGroup() {
	}

	public UserGroup(User user, Groups groups) {
		this.user = user;
		this.groups = groups;
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
	@JoinColumn(name = "idGroup", nullable = false)
	public Groups getGroups() {
		return this.groups;
	}

	public void setGroups(Groups groups) {
		this.groups = groups;
	}

}
