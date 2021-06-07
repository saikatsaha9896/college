package com.saikat.college.exception;

import java.util.Collection;

import org.apache.tomcat.util.buf.StringUtils;

public class MandatoryFieldNotFoundException extends RuntimeException{
	public MandatoryFieldNotFoundException() {
		super("Mandatory Fields Not Found");
	}
	
	public MandatoryFieldNotFoundException(Collection<String> fields) {
		super("Mandatory Fields (" + StringUtils.join(fields, ',') + ") Not Found");
	}
}
