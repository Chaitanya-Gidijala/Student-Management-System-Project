package com.studentmanagement.project.StudentManagementSystem.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.studentmanagement.project.StudentManagementSystem.entity.Student;
import com.studentmanagement.project.StudentManagementSystem.service.StudentService;


@Controller

public class StudentController {
	
	private StudentService studentService;

	public StudentController(StudentService studentService)
	{
		super();
		this.studentService = studentService;
	}
	
	//Home Page
	@GetMapping("/solopro")
	public String homePage() 
	{
		return "homepage";
	}
	// handler method to handle list students and return mode and view
	@GetMapping("/students")
	public String listStudents(Model model) 
	{
		List<Student> students = studentService.getAllStudents();
		model.addAttribute("students", students);
		return "students";
	}
	
	//Go to add student form when click Add button
	@GetMapping("/students/new")
	public String createStudentForm(Model model)
	{
		
		// create student object to hold student form data
		Student student = new Student();
		model.addAttribute("student", student);
		return "create_student";	
	}
	
	//save/insert student into database
	@PostMapping("/students")
	public String saveStudent(Student student)
	{
		studentService.saveStudent(student);
		return "redirect:/students";
	}
	
	//get details for update Student
	@GetMapping("/students/edit/{id}")
	public String editStudentForm(@PathVariable int id, Model model)
	{
		Student result =  studentService.getStudentById(id);
		model.addAttribute("student",result);
		return "edit_student";
	}

	//update student and redirect to student list..
	@PostMapping("/students/{id}")
	public String updateStudent(@PathVariable int id,
			@ModelAttribute("student") Student student,
			Model model)
	{		
		// get student from database by id
		Student existingStudent = studentService.getStudentById(id);
		existingStudent.setId(id);
		existingStudent.setFirstName(student.getFirstName());
		existingStudent.setLastName(student.getLastName());
		existingStudent.setEmail(student.getEmail());
		
		// save updated student object
		studentService.updateStudent(existingStudent);
		return "redirect:/students";		
	}
	
	// handler method to handle delete student request
	@GetMapping("/students/{id}")
	public String deleteStudent(@PathVariable Long id)
	{
		studentService.deleteStudentById(id);
		return "redirect:/students";
	}	
	
	//logout 
	@GetMapping("/logout")
	public String logout()
	{
		return "logout";
	}
	
	
}