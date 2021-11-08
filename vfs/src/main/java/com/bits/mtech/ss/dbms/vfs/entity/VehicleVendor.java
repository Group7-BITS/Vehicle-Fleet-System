package com.bits.mtech.ss.dbms.vfs.entity;

//import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "VehicleVendor")
public class VehicleVendor {
	/**
	 * this file is updated by yogesh. please don't modigy this
	 */
	private @Id @GeneratedValue Long id;
	
	
	@Column(name = "VENDOR_ID")
	private String vendorId;
	
	@Column(name = "VEHICLE_ID")
	private String vehicleId;
	

	public VehicleVendor(String vendorId, String vehicleId) {
		super();
		this.vendorId = vendorId;
		this.vehicleId = vehicleId;
//vehicleclass
	}

	

	public VehicleVendor() {
		super();
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getVendorId() {
		return vendorId;
	}

	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}

	public String getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(String vehicleId) {
		this.vehicleId = vehicleId;
	}

	

	
	
}
