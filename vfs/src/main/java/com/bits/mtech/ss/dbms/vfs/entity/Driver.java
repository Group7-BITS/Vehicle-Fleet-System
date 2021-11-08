package com.bits.mtech.ss.dbms.vfs.entity;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This file is updated by Ashrith Shetty.
 */

@Entity
@Table(name = "Driver")
public class Driver {
	private @Id @GeneratedValue Long id;
	
	@Column(name = "DRIVER_LICENSE")
	private Date driverlicense;

	@Column(name = "LICENSE_EXPIRY")
	private Date licenseExpiry;

	@Column(name = "LICENSE_TYPE")
	private String licenseType;
	
	
	public Driver() {
		super();
	}
	
	public Driver(Date driverlicense, Date licenseExpiry, String licenseType) {
		super();
		this.driverlicense = driverlicense;
		this.licenseExpiry = licenseExpiry;
		this.licenseType = licenseType;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDriverlicense() {
		return driverlicense;
	}

	public void setDriverlicense(Date driverlicense) {
		this.driverlicense = driverlicense;
	}

	public Date getLicenseExpiry() {
		return licenseExpiry;
	}

	public void setLicenseExpiry(Date licenseExpiry) {
		this.licenseExpiry = licenseExpiry;
	}

	public String getLicenseType() {
		return licenseType;
	}

	public void setLicenseType(String licenseType) {
		this.licenseType = licenseType;
	}



}
