package com.bits.mtech.ss.dbms.vfs.entity;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Booking")
public class Booking {
	private @Id @GeneratedValue Long id;
	
	@Column(name = "SOURCE_LOCATION")
	private String sourceLocation;
	
	@Column(name = "DESTINATION")
	private String destination;
	
	@Column(name = "BOOKING_DATE")
	private Date bookingDate;
	
	@Column(name = "CUSTOMER_ID")
	private String customerId;
	
	@Column(name = "DRIVER_ID")
	private String driverId;
	
	@Column(name = "VEHICLE_ID")
	private String vehicleId;
	
	@Column(name = "STATUS")
	private String status;
	
	public Booking(){
		super();
	}
	
	public Booking(String sourceLocation, String destination, Date bookingDate, String customerId, String driverId,
			String vehicleId, String status) {
		super();
		this.sourceLocation = sourceLocation;
		this.destination = destination;
		this.bookingDate = bookingDate;
		this.customerId = customerId;
		this.driverId = driverId;
		this.vehicleId = vehicleId;
		this.status = status;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSourceLocation() {
		return sourceLocation;
	}

	public void setSourceLocation(String sourceLocation) {
		this.sourceLocation = sourceLocation;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Date getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getDriverId() {
		return driverId;
	}

	public void setDriverId(String driverId) {
		this.driverId = driverId;
	}

	public String getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(String vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}


