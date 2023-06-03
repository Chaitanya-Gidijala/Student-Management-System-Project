package com.studentmanagement.project.StudentManagementSystem.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.studentmanagement.project.StudentManagementSystem.entity.Subjects;
import com.studentmanagement.project.StudentManagementSystem.service.Subjectservice;


@Controller
public class SubjectController {

	private Subjectservice subjectservice;
	
	public SubjectController(Subjectservice subjectservice) {
		super();
		this.subjectservice = subjectservice;
	}
	
	@GetMapping("/subjects")
	public String getAllSubjects(Model model)
	{
		List<Subjects> subjects = subjectservice.getAllSubjects();
		model.addAttribute("subjects", subjects);
		return "subjects";
	}
	
	@GetMapping("/subjects/new")
	public String createSubjectForm(Model model)
	{
		Subjects subject = new Subjects();
		model.addAttribute("subject", subject);
		return "create_subject";
	}
	@PostMapping("/subjects")
	public String saveSubject(Subjects subject)
	{
		subjectservice.saveSubject(subject);
		return "redirect:/subjects";
	}
	
	//get details for update Subject
	@GetMapping("/subjects/edit/{id}")
	public String editSubjectForm(@PathVariable int id, Model model)
	{
		Subjects subject =  subjectservice.getSubjectById(id);
		model.addAttribute("subject",subject);
		return "update_subject";
	}

	//update subject and redirect to subjects list..
	@PostMapping("/subjects/{id}")
	public String updateSubject(@PathVariable int id,
			@ModelAttribute("subject") Subjects subjects,
			Model model)
	{		
		// get Subject from database by id
		Subjects existingStudent = subjectservice.getSubjectById(id);
		existingStudent.setId(id);
		existingStudent.setSubjectName(subjects.getSubjectName());
				
		// save updated Subject object
		subjectservice.updateSubject(existingStudent);
		return "redirect:/subjects";		
	}
	
	// handler method to handle delete Subject request
	@GetMapping("/subjects/{id}")
	public String deleteSubject(@PathVariable int id)
	{
		subjectservice.deleteSubjectById(id);
		return "redirect:/subjects";
	}	
	
	
}
