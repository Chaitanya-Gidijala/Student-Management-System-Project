package com.studentmanagement.project.StudentManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.studentmanagement.project.StudentManagementSystem.entity.Subjects;

public interface SubjectRepository extends JpaRepository<Subjects, Integer>{

}
