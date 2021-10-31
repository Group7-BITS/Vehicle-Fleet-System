package com.bits.mtech.ss.dbms.vfs.entity;
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
	private String driverlicense;

	@Column(name = "LICENSE_EXPIRY")
	private String licenseExpiry;

	@Column(name = "LICENSE_TYPE")
	private String licenseType;
	
	
	public Driver(String driverlicense, String licenseExpiry, String licenseType) {
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

	public String getDriverlicense() {
		return driverlicense;
	}

	public void setDriverlicense(String driverlicense) {
		this.driverlicense = driverlicense;
	}

	public String getLicenseExpiry() {
		return licenseExpiry;
	}

	public void setLicenseExpiry(String licenseExpiry) {
		this.licenseExpiry = licenseExpiry;
	}

	public String getLicenseType() {
		return licenseType;
	}

	public void setLicenseType(String licenseType) {
		this.licenseType = licenseType;
	}



}
