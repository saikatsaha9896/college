package com.saikat.college.api;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.saikat.college.bean.Student;

public interface StudentAPI {
	
	@GetMapping(path = "/students")
	public ResponseEntity<List<Student>> listAll(Model model);
	
	@GetMapping(path = "/students/{id}")
	public ResponseEntity<Student> getStudent(@PathVariable Long id);
	
	@PutMapping(path = "/students/{id}")
	public ResponseEntity<Object> updateStudent(@PathVariable Long id, @RequestBody Map<String, Object> sourceMap);
	
	@PostMapping(path = "/students")
	public ResponseEntity<Object> createStudent(@Valid @RequestBody Student student);
	
	@DeleteMapping(path = "/students/{id}")
	public ResponseEntity<Object> deleteStudent(@PathVariable Long id);
}
