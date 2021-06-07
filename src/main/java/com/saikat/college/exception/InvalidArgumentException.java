package com.saikat.college.exception;

import java.util.Collection;

import org.apache.tomcat.util.buf.StringUtils;

public class InvalidArgumentException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidArgumentException() {
		super("Invalid Arguement Passed");
	}
	
	public InvalidArgumentException(Collection<String> fields) {
		super("Invalid Arguements (" + StringUtils.join(fields, ',') + ") Passed");
	}
}
