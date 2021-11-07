package com.bits.mtech.ss.dbms.vfs.entity;

//import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "VehicleType")
public class VehicleType {
	/**
	 * this file is updated by yogesh. please don't modigy this
	 */
	private @Id @GeneratedValue Long id;
	@Column(name = "TYPE_CODE")
	private String typeCode;

	@Column(name = "CAPACITY")
	private String capacity;



	public VehicleType(String typeCode, String capacity) {
		super();
		this.typeCode = typeCode;
		this.capacity = capacity;
		
//vehicleclass
	}

	

	public VehicleType() {
		super();
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTypeCode() {
		return typeCode;
	}

	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}

	public String getCapacity() {
		return capacity;
	}

	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}

	
	
	
}
