package com.saikat.college.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.saikat.college.api.StudentAPI;
import com.saikat.college.bean.Student;
import com.saikat.college.dao.StudentRepository;
import com.saikat.college.service.StudentService;

@RestController
public class StudentController implements StudentAPI {

	@Autowired
    private StudentRepository studentRepo;
	
	@Autowired
	private StudentService service;

	@Override
    public ResponseEntity<List<Student>> listAll(Model model) {
        return new ResponseEntity<List<Student>>(service.listAll(), HttpStatus.OK);
    	//return service.listAll();
    }

    @Override
    public ResponseEntity<Student> getStudent(Long id) {
    	return new ResponseEntity<Student>(service.getStudent(id), HttpStatus.OK);
    }
    
	@Override
	public ResponseEntity<Object> updateStudent(Long id, Map<String, Object> sourceMap) {
		service.updateStudent(id, sourceMap);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	@Override
	public ResponseEntity<Object> createStudent(Student student) {
		return new ResponseEntity<Object>(service.createStudent(student), HttpStatus.CREATED);
	}
	
	@Override
	public ResponseEntity<Object> deleteStudent(Long id) {
		service.deleteStudent(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}
