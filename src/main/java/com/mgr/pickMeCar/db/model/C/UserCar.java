package com.mgr.pickMeCar.db.model.C;
// Generated 2016-03-07 13:22:21 by Hibernate Tools 3.4.0.CR1

/**
 * UserCar generated by hbm2java
 */
public class UserCar implements java.io.Serializable {

	private Integer id;
	private Car car;
	private User user;

	public UserCar() {
	}

	public UserCar(Car car, User user) {
		this.car = car;
		this.user = user;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Car getCar() {
		return this.car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
