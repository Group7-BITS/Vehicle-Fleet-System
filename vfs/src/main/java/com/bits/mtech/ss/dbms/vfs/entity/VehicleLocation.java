package com.bits.mtech.ss.dbms.vfs.entity;
//import java.util.Date;

import java.sql.NClob;
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
	
	
	@Column(name = "VEH_LOC")
	private NClob vehicleLocation;

	

	public VehicleLocation(NClob vehicleLocation) {
		super();
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

	public NClob getVehicleLocation() {
		return vehicleLocation;
	}

	public void setVehicleLocation(NClob vehicleLocation) {
		this.vehicleLocation = vehicleLocation;
	}

	
}
