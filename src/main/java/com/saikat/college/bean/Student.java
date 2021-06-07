package com.saikat.college.bean;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity(name = "students")
@Table(name = "students", schema = "college_data")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	@Column(nullable = false)
	@JsonProperty("first_name")
	private String firstName;
	@JsonProperty("last_name")
	private String lastName;
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
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
	public Student(Long id, String firstName, String lastName) {
		super();
		Id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
}
