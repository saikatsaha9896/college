package com.saikat.college.exception;

import java.util.Collection;

import org.apache.tomcat.util.buf.StringUtils;

public class InvalidArgumentOrMandatoryFieldNotFoundException extends RuntimeException {
	public InvalidArgumentOrMandatoryFieldNotFoundException() {
		super("Either Inavlid Argument(s) Passed Or Mandatory Field(s) Not Found");
	}
	
	public InvalidArgumentOrMandatoryFieldNotFoundException(Collection<String> fields) {
		super("Either Inavlid Argument(s) (" + StringUtils.join(fields, ',')
		+ ") Passed Or Mandatory Field(s) (" + StringUtils.join(fields, ',') + ") Not Found");
	}
}
