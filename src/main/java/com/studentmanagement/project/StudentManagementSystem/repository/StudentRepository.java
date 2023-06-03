package com.studentmanagement.project.StudentManagementSystem.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.studentmanagement.project.StudentManagementSystem.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

	Optional<Student> findById(int id);

}
