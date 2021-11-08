package com.bits.mtech.ss.dbms.vfs.entity;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "VehicleInsurance")
public class VehicleInsurance {
	private @Id @GeneratedValue Long id;
	
	@Column(name = "INSURANCE_START_DATE")
	private Date insuranceStartDate;
	
	@Column(name = "INSURANCE_END_DATE")
	private Date insuranceEndDate;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getInsuranceStartDate() {
		return insuranceStartDate;
	}

	public void setInsuranceStartDate(Date insuranceStartDate) {
		this.insuranceStartDate = insuranceStartDate;
	}

	public Date getInsuranceEndDate() {
		return insuranceEndDate;
	}

	public void setInsuranceEndDate(Date insuranceEndDate) {
		this.insuranceEndDate = insuranceEndDate;
	}

	public VehicleInsurance() {
		super();
	}
	
	public VehicleInsurance(Date insuranceStartDate, Date insuranceEndDate) {
		super();
		this.insuranceStartDate = insuranceStartDate;
		this.insuranceEndDate = insuranceEndDate;

	}
}
