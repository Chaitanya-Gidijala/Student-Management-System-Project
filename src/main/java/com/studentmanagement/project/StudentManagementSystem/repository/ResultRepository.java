package com.studentmanagement.project.StudentManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.studentmanagement.project.StudentManagementSystem.entity.Results;

public interface ResultRepository extends JpaRepository<Results, Integer> {

}
