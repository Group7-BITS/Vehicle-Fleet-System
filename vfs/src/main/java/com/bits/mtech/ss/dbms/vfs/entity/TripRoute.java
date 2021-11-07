package com.bits.mtech.ss.dbms.vfs.entity;
import java.sql.NClob;

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
	private NClob gps;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public NClob gps() {
		return gps;
	}
	public void gps(NClob gps) {
		this.gps = gps;
	}
	
	public TripRoute() {
		super();
	}
	
	public TripRoute(NClob gps) {
		super();
		this.gps=gps;
	}	
}
