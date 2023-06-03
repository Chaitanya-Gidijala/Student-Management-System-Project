package com.studentmanagement.project.StudentManagementSystem.service;

import java.util.List;

import com.studentmanagement.project.StudentManagementSystem.entity.Subjects;

public interface Subjectservice {

	List<Subjects> getAllSubjects();
	
	Subjects saveSubject(Subjects subject);
	
	Subjects getSubjectById(int id);
	
	Subjects updateSubject(Subjects subjects);
	
	void deleteSubjectById(int id);
}
