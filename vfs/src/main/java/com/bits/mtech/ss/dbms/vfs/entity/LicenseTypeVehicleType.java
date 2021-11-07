package com.bits.mtech.ss.dbms.vfs.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
//code updated by SreeHarshithaMandapaka
@Entity
@Table(name = "LicenseTypeVehicleType")
public class LicenseTypeVehicleType {
	private @Id @GeneratedValue Long id;
	
	@Column(name = "TYPECODE")
	private String TypeCode;
	
	@Column(name = "CAPACITY")
	private String capacity;
	
	public LicenseTypeVehicleType(String TypeCode, String capacity) {
		super();
		this.TypeCode=TypeCode;
		this.capacity=capacity;
	}	
	
	public LicenseTypeVehicleType() {
		super();
	}
	
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
}