package com.bits.mtech.ss.dbms.vfs;

public class VfsException  extends RuntimeException{

	/**
	 * Sample
	 */
	private static final long serialVersionUID = 1L;

	public VfsException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public VfsException(String message) {
		super(message);
	}

	public VfsException(Throwable cause) {
		super(cause);
	}
	
	

}
