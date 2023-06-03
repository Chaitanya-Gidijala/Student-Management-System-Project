package com.studentmanagement.project.StudentManagementSystem.service;

import java.util.List;

import com.studentmanagement.project.StudentManagementSystem.entity.Results;

public interface ResultService{

	List<Results> getAllResults();
	
	Results saveResult(Results result);
	
	Results getResultById(int id);
	
	Results updateResult(Results result);
	
	void deleteResultById(int id);
}
