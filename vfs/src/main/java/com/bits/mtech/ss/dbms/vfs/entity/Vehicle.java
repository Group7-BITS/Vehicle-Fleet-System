package com.bits.mtech.ss.dbms.vfs.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Vehicle")
public class Vehicle {
	private @Id @GeneratedValue Long id;
	@Column(name = "CHASIS_NUM")
	private String chasisNumber;

	@Column(name = "REG_NUM")
	private String registrationNumber;

	@Column(name = "REG_DATE")
	private Date registrationStartDate;

	public Vehicle(String chasisNumber, String registrationNumber, Date registrationStartDate) {
		super();
		this.chasisNumber = chasisNumber;
		this.registrationNumber = registrationNumber;
		this.registrationStartDate = registrationStartDate;
	}

	

	public Vehicle() {
		super();
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getChasisNumber() {
		return chasisNumber;
	}

	public void setChasisNumber(String chasisNumber) {
		this.chasisNumber = chasisNumber;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public Date getRegistrationStartDate() {
		return registrationStartDate;
	}

	public void setRegistrationStartDate(Date registrationStartDate) {
		this.registrationStartDate = registrationStartDate;
	}
	
	
	
}
