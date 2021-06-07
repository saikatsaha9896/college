package com.saikat.college.exception;

public class StudentNotFoundException extends RuntimeException {
	public StudentNotFoundException() {
		super("Student not found");
	}
	public StudentNotFoundException(String id) {
		super("Student not found with Id : " + id);
	}
	
}
