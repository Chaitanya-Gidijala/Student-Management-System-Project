package com.studentmanagement.project.StudentManagementSystem.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.studentmanagement.project.StudentManagementSystem.entity.Results;
import com.studentmanagement.project.StudentManagementSystem.repository.ResultRepository;
@Service
public class ResultServiceImpl implements ResultService 
{
	private ResultRepository repository;
	
	public ResultServiceImpl(ResultRepository theRepository)
	{
		this.repository = theRepository;
	}

	@Override
	public List<Results> getAllResults() {
		return repository.findAll();
	}

	@Override
	public Results saveResult(Results result) {
		return repository.save(result);
	}

	@Override
	public Results getResultById(int id) {
		return repository.findById(id).get();
	}

	@Override
	public Results updateResult(Results result) {
		return repository.save(result);
	}

	@Override
	public void deleteResultById(int id) {
		repository.deleteById(id);
	}

}
