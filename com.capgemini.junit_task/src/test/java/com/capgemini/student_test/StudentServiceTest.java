package com.capgemini.student_test;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.capgemini.student.Student;
import com.capgemini.student.StudentService;

public class StudentServiceTest {
	
	Student student;
	StudentService service;
	
	@BeforeAll
	void setup() {
		service = new StudentService();
		student = new Student(1, "aman", 40, 45, 65);
	}
	
	@Test
	void testIsPassed() {
		assertTrue(service.isPassed(student));
	}
}
