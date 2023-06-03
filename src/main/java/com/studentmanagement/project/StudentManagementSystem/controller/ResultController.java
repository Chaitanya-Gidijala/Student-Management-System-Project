package com.studentmanagement.project.StudentManagementSystem.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.studentmanagement.project.StudentManagementSystem.entity.Results;
import com.studentmanagement.project.StudentManagementSystem.service.ResultService;

@Controller
public class ResultController {

	private ResultService resultService;

	public ResultController(ResultService resultService)
	{
		super();
		this.resultService = resultService;
	} 

	
	// handler method to handle list results and return mode and view
	@GetMapping("/results")
	public String listStudents(Model model) 
	{
		List<Results> results = resultService.getAllResults();
		model.addAttribute("results", results);
		return "results_menu";
	}
	
	//Go to add result form when click Add button
	@GetMapping("/results/new")
	public String createStudentForm(Model model)
	{
		
		// create result object to hold result form data
		Results result = new Results();
		model.addAttribute("result", result);
		return "create_result";	
	}
	
	//save/insert result into database
	@PostMapping("/results")
	public String saveResult(Results result)
	{
		resultService.saveResult(result);
		return "redirect:/results";
	}
	
	//get details for update result
	@GetMapping("/results/edit/{id}")
	public String editStudentForm(@PathVariable int id, Model model)
	{
		Results result =  resultService.getResultById(id);
		model.addAttribute("result",result);
		return "update_result";
	}

	//update result and redirect to results list..
	@PostMapping("/results/{id}")
	public String updateStudent(@PathVariable int id,
			@ModelAttribute("result") Results result,
			Model model)
	{		
		// get result from database by id
		Results existingStudent = resultService.getResultById(id);
		existingStudent.setId(id);
		existingStudent.setHallTicketNo(result.getHallTicketNo());
		existingStudent.setFullName(result.getFullName());
		existingStudent.setMarks(result.getMarks());
		
		// save updated result object
		resultService.updateResult(existingStudent);
		return "redirect:/results";		
	}
	
	// handler method to handle delete result request
	@GetMapping("/results/{id}")
	public String deleteResult(@PathVariable int id)
	{
		resultService.deleteResultById(id);
		return "redirect:/results";
	}	
	
	
}
