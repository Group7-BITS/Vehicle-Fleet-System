package com.bits.mtech.ss.dbms.vfs.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
//code updated by SreeHarshithaMandapaka
@Entity
@Table(name = "TripRoute")
public class TripRoute {
	private @Id @GeneratedValue Long id;
	@Column(name = "GPS")
	private String gps;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String gps() {
		return gps;
	}
	public void gps(String gps) {
		this.gps = gps;
	}
	
	public TripRoute() {
		super();
	}
	
	public TripRoute(String gps) {
		super();
		this.gps=gps;
	}	
}
