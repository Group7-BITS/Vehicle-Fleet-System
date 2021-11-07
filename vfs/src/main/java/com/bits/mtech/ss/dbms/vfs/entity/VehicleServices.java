package com.bits.mtech.ss.dbms.vfs.entity;
import java.sql.NClob;
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
	private NClob serviceLocation;

	@Column(name = "SER_RECOMMEND")
	private NClob serviceRecommend;
	
	@Column(name = "SER_ISSUE")
	private NClob serviceIssue;
	

	public VehicleServices(String vehicleId, Date serviceDate, NClob serviceLocation, NClob serviceRecommend, NClob serviceIssue) {
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

	public NClob  getServiceLocation() {
		return serviceLocation;
	}

	public void setServiceLocation(NClob serviceLocation) {
		this.serviceLocation = serviceLocation;
	}

	public NClob getServiceRecommend() {
		return serviceRecommend;
	}

	public void setServiceRecommend(NClob serviceRecommend) {
		this.serviceRecommend = serviceRecommend;
	}
	
	public NClob getServiceIssue() {
		return serviceIssue;
	}

	public void setServiceIssue(NClob serviceIssue) {
		this.serviceIssue = serviceIssue;
	}
}
