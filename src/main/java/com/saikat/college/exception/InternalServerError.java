package com.saikat.college.exception;

public class InternalServerError extends RuntimeException {
	
	public InternalServerError() {
		super("Oops...Something went wrong");
	}
}
