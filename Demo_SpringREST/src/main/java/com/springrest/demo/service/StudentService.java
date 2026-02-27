package com.springrest.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springrest.demo.model.Student;
import com.springrest.demo.repository.StudentRepository;

@Service
public class StudentService {
	
	private StudentRepository studentRepository;

	public StudentService(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}
	
	public List<Student> showStudents(){
		return studentRepository.findAll();
	}
	
	public Student getStudentById(long id) {
		return studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student does not exist!"));
	}
	
	public void saveStudent(Student student) {
		studentRepository.save(student);
	}
	
	public void updateStudentById(long id, Student student) {
		Student existing = getStudentById(id);
		
		existing.setName(student.getName());
		existing.setEmail(student.getEmail());
		existing.setContactNumber(student.getContactNumber());
		
		
	}
	
	public void deleteStudentById(long id) {
		studentRepository.deleteById(id);
	}
	
	
}
