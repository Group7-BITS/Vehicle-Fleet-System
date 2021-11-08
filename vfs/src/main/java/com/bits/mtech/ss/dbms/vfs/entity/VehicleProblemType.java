package com.bits.mtech.ss.dbms.vfs.entity;
//import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "VehicleProblemType")
public class VehicleProblemType {
	/**
	 * this file is updated by yogesh. please don't modigy this
	 */
	private @Id @GeneratedValue Long id;
	
	@Column(name = "TYPE")
	private String type;

	@Column(name = "SEVIRITY")
	private String sevirity;

	
	public VehicleProblemType(String type, String sevirity) {
		super();
		this.type = type;
		this.sevirity = sevirity;

	}

	

	public VehicleProblemType() {
		super();
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSevirity() {
		return sevirity;
	}

	public void setSevirity(String sevirity) {
		this.sevirity = sevirity;
	}

	
	
}
