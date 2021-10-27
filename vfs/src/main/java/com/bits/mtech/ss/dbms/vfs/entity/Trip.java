package com.bits.mtech.ss.dbms.vfs.entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Trip {
	private @Id @GeneratedValue Long id;
}
