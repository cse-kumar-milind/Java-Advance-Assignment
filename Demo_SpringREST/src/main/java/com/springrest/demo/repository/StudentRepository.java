package com.springrest.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springrest.demo.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{

}
