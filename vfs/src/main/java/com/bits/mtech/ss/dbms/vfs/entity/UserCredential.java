package com.bits.mtech.ss.dbms.vfs.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "UserCredential")
public class UserCredential {
	private @Id @GeneratedValue Long id;
	
	@Column(name = "ENCRYPT_PASS")
	private String encryptPassword;
	
	@Column(name = "ENCRYPT_KEY")
	private String encryptKey;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEncryptPassword() {
		return encryptPassword;
	}

	public void setEncryptPassword(String encryptPassword) {
		this.encryptPassword = encryptPassword;
	}

	public String getEncryptKey() {
		return encryptKey;
	}

	public void setEncryptKey(String encryptKey) {
		this.encryptKey = encryptKey;
	}

	public UserCredential() {
		super();
	}
	
	public UserCredential(String encryptPassword, String encryptKey) {
		super();
		this.encryptPassword = encryptPassword;
		this.encryptKey = encryptKey;
	}
	
}
