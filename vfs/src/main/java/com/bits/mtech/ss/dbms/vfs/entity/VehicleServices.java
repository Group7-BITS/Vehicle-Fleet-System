package com.bits.mtech.ss.dbms.vfs.entity;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "VehicleServices")
public class VehicleServices {
	/**
	 * this file is updated by yogesh. please don't modigy this
	 */
	private @Id @GeneratedValue Long id;
	
	@Column(name = "VEH_ID")
	private String vehicleId;
	
	@Column(name = "SER_DATE")
	private Date serviceDate;

	@Column(name = "SER_LOC")
	private String serviceLocation;

	@Column(name = "SER_RECOMMEND")
	private String serviceRecommend;
	
	@Column(name = "SER_ISSUE")
	private String serviceIssue;
	

	public VehicleServices(String vehicleId, Date serviceDate, String serviceLocation, String serviceRecommend, String serviceIssue) {
		super();
		this.vehicleId = vehicleId;
		this.serviceDate = serviceDate;
		this.serviceLocation = serviceLocation;
		this.serviceRecommend = serviceRecommend;
		this.serviceIssue = serviceIssue;
	}

	

	public VehicleServices() {
		super();
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(String vehicleId) {
		this.vehicleId = vehicleId;
	}

	public Date getServiceDate() {
		return serviceDate;
	}

	public void setServiceDate(Date serviceDate) {
		this.serviceDate = serviceDate;
	}

	public String  getServiceLocation() {
		return serviceLocation;
	}

	public void setServiceLocation(String serviceLocation) {
		this.serviceLocation = serviceLocation;
	}

	public String getServiceRecommend() {
		return serviceRecommend;
	}

	public void setServiceRecommend(String serviceRecommend) {
		this.serviceRecommend = serviceRecommend;
	}
	
	public String getServiceIssue() {
		return serviceIssue;
	}

	public void setServiceIssue(String serviceIssue) {
		this.serviceIssue = serviceIssue;
	}
}
