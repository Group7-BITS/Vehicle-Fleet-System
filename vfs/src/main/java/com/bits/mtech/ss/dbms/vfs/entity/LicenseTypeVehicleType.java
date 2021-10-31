package com.bits.mtech.ss.dbms.vfs.entity;
import java.sql.NClob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
//code updated by SreeHarshithaMandapaka
@Entity
public class LicenseTypeVehicleType {
	private @Id @GeneratedValue Long id;
	@Column(name = "TYPECODE")
	private String TypeCode;
	@Column(name = "CAPACITY")
	private String capacity;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTypeCode() {
		return TypeCode;
	}
	public void setTypeCode(String typeCode) {
		TypeCode = typeCode;
	}
	public String getCapacity() {
		return capacity;
	}
	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}
	public LicenseTypeVehicleType(Long id, String TypeCode, String capacity) {
		super();
		this.id=id;
		this.TypeCode=TypeCode;
		this.capacity=capacity;
		
		
	}	
	
}
