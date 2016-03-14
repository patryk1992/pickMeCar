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
 * Car generated by hbm2java
 */
@Entity
@Table(name = "car", catalog = "drive_db")
public class Car implements java.io.Serializable {

	private Integer id;
	private String brand;
	private String model;
	private String space;
	private String description;
	private Set userCars = new HashSet(0);

	public Car() {
	}

	public Car(String brand, String model) {
		this.brand = brand;
		this.model = model;
	}

	public Car(String brand, String model, String space, String description, Set userCars) {
		this.brand = brand;
		this.model = model;
		this.space = space;
		this.description = description;
		this.userCars = userCars;
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

	@Column(name = "brand", nullable = false, length = 45)
	public String getBrand() {
		return this.brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	@Column(name = "model", nullable = false, length = 45)
	public String getModel() {
		return this.model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	@Column(name = "space", length = 45)
	public String getSpace() {
		return this.space;
	}

	public void setSpace(String space) {
		this.space = space;
	}

	@Column(name = "description")
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "car")
	public Set getUserCars() {
		return this.userCars;
	}

	public void setUserCars(Set userCars) {
		this.userCars = userCars;
	}

}
