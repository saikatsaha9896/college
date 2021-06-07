package com.saikat.college.validator;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.saikat.college.bean.Student;
import com.saikat.college.dao.StudentRepository;
import com.saikat.college.exception.InvalidArgumentException;
import com.saikat.college.exception.InvalidArgumentOrMandatoryFieldNotFoundException;
import com.saikat.college.exception.MandatoryFieldNotFoundException;
import com.saikat.college.exception.NoArgumentsFoundException;
import com.saikat.college.exception.StudentNotFoundException;

public class CommonValidators {
	
	@Autowired
	private static StudentRepository studentDao;
	
	public static void checkRedundantFieldExistance(Map<String, Object> map, Collection<String> mandatoryFields) {
		checkRedundantFieldExistance(map, mandatoryFields, null);
	}
	
	public static void checkRedundantFieldExistance(Map<String, Object> map, Collection<String> mandatoryFields,
			Collection<String> optionalFields) {
		if (Objects.isNull(map) || map.isEmpty()) {
			throw new NoArgumentsFoundException();
		}
		Set<String> fields = new HashSet<>();
		if (Objects.nonNull(mandatoryFields) && !mandatoryFields.isEmpty()) {
			for (String field : mandatoryFields) {
				if (!map.containsKey(field)) {
					fields.add(field);
				}
			}
			if (!fields.isEmpty()) {
				throw new MandatoryFieldNotFoundException(fields);
			}
		}
		Collection<String> allPossibleFieldsCollection = new HashSet<>();
		if (Objects.nonNull(mandatoryFields) && !mandatoryFields.isEmpty()) {
			allPossibleFieldsCollection.addAll(mandatoryFields);
		}
		if (Objects.nonNull(optionalFields) && !optionalFields.isEmpty()) {
			allPossibleFieldsCollection.addAll(optionalFields);
		}
		if (allPossibleFieldsCollection.isEmpty()) {
			throw new InvalidArgumentException();
		}
		for (String field : map.keySet()) {
			if (!allPossibleFieldsCollection.contains(field)) {
				fields.add(field);
			}
		}
		if (!fields.isEmpty()) {
			throw new InvalidArgumentException(fields);
		}
	}
	
	public static void checkStudentObjectValidation(Student student) {
		if(Objects.isNull(student)) {
			throw new NoArgumentsFoundException();
		}
		if (Objects.nonNull(student.getId())) {
			studentDao.findById(student.getId()).orElseThrow(() -> new StudentNotFoundException(student.getId() + ""));
		}
		if (Objects.isNull(student.getFirstName()) || !StringUtils.hasLength(student.getFirstName())) {
			throw new InvalidArgumentOrMandatoryFieldNotFoundException(Arrays.asList("first_name"));
		}
	}
}
