package com.saikat.college.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.saikat.college.bean.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
	
	@Modifying
	@Query("update students s set s.firstName = ?2, s.lastName = ?3 where s.id = ?1")
	void updateStudent(Long id, String firstName, String LastName);
}
