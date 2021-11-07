package com.bits.mtech.ss.dbms.vfs.entity;

import java.sql.NClob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This file is updated by Ashrith Shetty.
 */

@Entity
@Table(name = "Address")
public class Address {
	private @Id @GeneratedValue Long id;
	@Column(name = "GEO_LOCATION_CORDINATES")
	private String geoLocationCordinates;

	@Column(name = "STREET")
	private String street;

	@Column(name = "FLAT_NUM")
	private String flatNumber;

	@Column(name = "CITY")
	private String city;

	@Column(name = "PINCODE")
	private String pinCode;

	@Column(name = "COUNTRY")
	private String country;

	@Column(name = "LANDMARK")
	private String landMark;

	public Address() {
		super();
	}
	
	public Address(String geoLocationCordinates, String street, String flatNumber,
			String city, String pinCode, String country, String landMark) {
		super();
		this.geoLocationCordinates = geoLocationCordinates;
		this.street = street;
		this.flatNumber = flatNumber;
		this.city = city;
		this.pinCode = pinCode;
		this.country = country;
		this.landMark = landMark;
	}
	
	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getGeoLocationCordinates() {
		return geoLocationCordinates;
	}



	public void setGeoLocationCordinates(String geoLocationCordinates) {
		this.geoLocationCordinates = geoLocationCordinates;
	}



	public String getStreet() {
		return street;
	}



	public void setStreet(String street) {
		this.street = street;
	}



	public String getFlatNumber() {
		return flatNumber;
	}



	public void setFlatNumber(String flatNumber) {
		this.flatNumber = flatNumber;
	}



	public String getCity() {
		return city;
	}



	public void setCity(String city) {
		this.city = city;
	}



	public String getPinCode() {
		return pinCode;
	}



	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}



	public String getCountry() {
		return country;
	}



	public void setCountry(String country) {
		this.country = country;
	}



	public String getLandMark() {
		return landMark;
	}



	public void setLandMark(String landMark) {
		this.landMark = landMark;
	}

}