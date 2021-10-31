package com.bits.mtech.ss.dbms.vfs.entity;

//import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "User")
public class User {
	/**
	 * this file is updated by yogesh. please don't modigy this
	 */
	private @Id @GeneratedValue Long id;
	
	@Column(name = "F_NAME")
	private String firstName;

	@Column(name = "L_NAME")
	private String lastName;

	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "PHONE")
	private String phoneNumber;
	
	@Column(name = "ROLE")
	private String role;
	
	public User(String firstName, String lastName, String email, String phoneNumber,String role) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.role = role;

	}

	

	public User() {
		super();
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getrole() {
		return role;
	}

	public void setrole(String role) {
		this.role = role;
	}
	
	
	
	
}
