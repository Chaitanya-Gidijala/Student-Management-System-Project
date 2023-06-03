package com.studentmanagement.project.StudentManagementSystem.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.studentmanagement.project.StudentManagementSystem.entity.Subjects;
import com.studentmanagement.project.StudentManagementSystem.repository.SubjectRepository;

@Service
public class SubjectServiceImpl implements Subjectservice {

	private SubjectRepository subjectRepository;
	
	public SubjectServiceImpl(SubjectRepository subjectRepository) {
		super();
		this.subjectRepository = subjectRepository;
	}
	
	@Override
	public List<Subjects> getAllSubjects() {
		return subjectRepository.findAll();
	}

	@Override
	public Subjects saveSubject(Subjects subjects) {
		return subjectRepository.save(subjects);
	}

	@Override
	public Subjects getSubjectById(int id) {
		return subjectRepository.findById(id).get();
	}

	@Override
	public Subjects updateSubject(Subjects subjects) {
		return subjectRepository.save(subjects);
	}

	@Override
	public void deleteSubjectById(int id) {
		subjectRepository.deleteById(id);
	}

}
