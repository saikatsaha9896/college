package com.saikat.college.service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.util.MapUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.saikat.college.bean.Student;
import com.saikat.college.dao.StudentRepository;
import com.saikat.college.exception.InternalServerError;
import com.saikat.college.exception.InvalidArgumentException;
import com.saikat.college.exception.StudentNotFoundException;
import com.saikat.college.validator.CommonValidators;

@Service
public class StudentService {

	@Autowired
	private StudentRepository dao;
	
	public List<Student> listAll() {
		try {
			List<Student> listStudents = dao.findAll();
	        return listStudents;
		} catch (Exception e) {
			throw new InternalServerError();
		}
	}
	
	public Student getStudent(Long id) {
		return dao.findById(id).orElseThrow(() -> new StudentNotFoundException(id + ""));
	}
	
	@Transactional
	public void updateStudent(Long id, Map<String, Object> sourceMap) {
		Student student = dao.findById(id).orElseThrow(() -> new StudentNotFoundException(id+""));
		CommonValidators.checkRedundantFieldExistance(sourceMap, null, Arrays.asList("first_name", "last_name"));
		if (sourceMap.containsKey("first_name")) {
			if (Objects.nonNull(sourceMap.get("first_name")) && sourceMap.get("first_name") instanceof String) {
				student.setFirstName(sourceMap.get("first_name").toString());
			} else {
				throw new InvalidArgumentException(Arrays.asList("first_name"));
			}
		}
		if (sourceMap.get("last_name") instanceof String) {
			student.setLastName(sourceMap.get("last_name").toString());
		} else {
			throw new InvalidArgumentException(Arrays.asList("last_name"));
		}
		try {
			dao.updateStudent(id, student.getFirstName(), student.getLastName());
		} catch (Exception e) {
			throw new InternalServerError();
		}
	}
	
	public Long createStudent(Student student) {
		CommonValidators.checkStudentObjectValidation(student);
		try {
			Student createdStudent = dao.save(student);
			return createdStudent.getId();
		} catch (Exception e) {
			throw new InternalServerError();
		}
	}
	
	public void deleteStudent(Long id) {
		Student student = dao.findById(id).orElseThrow(() -> new StudentNotFoundException(id+""));
		try {
			dao.delete(student);
		} catch (Exception e) {
			throw new InternalServerError();
		}
	}
}
