package com.springrest.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.demo.model.Student;
import com.springrest.demo.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	private StudentService service;

	public StudentController(StudentService service) {
		this.service = service;
	}
	
	@GetMapping()
	public List<Student> getStudents(){
		return service.showStudents();
	}
	
	@GetMapping("/{id}")
	public Student getStudentById(@PathVariable long id) {
		return service.getStudentById(id);
	}
	
	@PostMapping()
	public ResponseEntity<Student> addStudent(@RequestBody Student student) {
		service.saveStudent(student);
		
		return new ResponseEntity<Student>(HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable long id, @RequestBody Student student){
		service.getStudentById(id);
		
		service.updateStudentById(id, student);
		
		return ResponseEntity.ok(student);
	}
	
	@DeleteMapping("/{id}")
	public void deleteStudent(@PathVariable Long id) {
		service.getStudentById(id);
		service.deleteStudentById(id);
	}
	
	
	
}
