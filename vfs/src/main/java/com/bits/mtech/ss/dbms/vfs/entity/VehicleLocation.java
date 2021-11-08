package com.bits.mtech.ss.dbms.vfs.entity;
//import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "VehicleLocation")
public class VehicleLocation {
	/**
	 * this file is updated by yogesh. please don't modigy this
	 */
	private @Id @GeneratedValue Long id;
	
	@Column(name = "VEH_ID")
	private String vehicleId;
	
	@Column(name = "VEH_LOC")
	private String vehicleLocation;

	

	public VehicleLocation(String vehicleId,String vehicleLocation) {
		super();
		this.vehicleId = vehicleId;
		this.vehicleLocation = vehicleLocation;
	}

	

	public VehicleLocation() {
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

	public String getVehicleLocation() {
		return vehicleLocation;
	}

	public void setVehicleLocation(String vehicleLocation) {
		this.vehicleLocation = vehicleLocation;
	}

	
}
