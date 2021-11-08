package com.bits.mtech.ss.dbms.vfs.entity;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Trip")
public class Trip {
	private @Id @GeneratedValue Long id;
	
	@Column(name = "TRIP_START_DATE")
	private Date tripStartDate;

	@Column(name = "TRIP_END_DATE")
	private Date tripEndDate;

	@Column(name = "TRIP_COST")
	private double tripCost;
	
	@Column(name = "TRIP_REVIEW")
	private String tripReview;
	
	@Column(name = "SOURCE_ADDRESS")
	private String sourceAddress;
	
	@Column(name = "DESTINATION_ADDRESS")
	private String destinationAddress;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getTripStartDate() {
		return tripStartDate;
	}

	public void setTripStartDate(Date tripStartDate) {
		this.tripStartDate = tripStartDate;
	}

	public Date getTripEndDate() {
		return tripEndDate;
	}

	public void setTripEndDate(Date tripEndDate) {
		this.tripEndDate = tripEndDate;
	}

	public double getTripCost() {
		return tripCost;
	}

	public void setTripCost(double tripCost) {
		this.tripCost = tripCost;
	}

	public String getTripReview() {
		return tripReview;
	}

	public void setTripReview(String tripReview) {
		this.tripReview = tripReview;
	}

	public String getSourceAddress() {
		return sourceAddress;
	}

	public void setSourceAddress(String sourceAddress) {
		this.sourceAddress = sourceAddress;
	}

	public String getDestinationAddress() {
		return destinationAddress;
	}

	public void setDestinationAddress(String destinationAddress) {
		this.destinationAddress = destinationAddress;
	}

	public Trip() {
		super();
	}
	
	public Trip(Date tripStartDate, Date tripEndDate, double tripCost, String tripReview, 
			String sourceAddress, String destinationAddress) {
		super();
		this.tripStartDate = tripStartDate;
		this.tripEndDate = tripEndDate;
		this.tripCost = tripCost;
		this.tripReview = tripReview;
		this.sourceAddress = sourceAddress;
		this.destinationAddress = destinationAddress;
	}
}
