package com.bits.mtech.ss.dbms.vfs.entity;
//import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "UserRole")
public class UserRole {
	private @Id @GeneratedValue Long id;
	/**
	 * this file is updated by yogesh. please don't modigy this
	 */
	@Column(name = "USER_ROLE")
	private String userRole;

	public UserRole(String userRole) {
		super();
		this.userRole = userRole;

	}

	

	public UserRole() {
		super();
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserRole() {
		return userRole;
	}

	public void getUserRole(String userRole) {
		this.userRole = userRole;
	}

	
	
	
	
}
