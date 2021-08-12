package com.login.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.login.entity.Student;
import com.login.exceptions.StudentException;
import com.login.service.StudentService;

@RestController
@RequestMapping("/api")
public class StudentController {
	@Autowired
	private StudentService stuService;
	
	
	/* This Method Add the student to Student table if data enetered is correct*/
	@CrossOrigin
	@PostMapping("/add")
	public String addStudent(@Valid @RequestBody Student stu,BindingResult br)throws StudentException{
		String err="";
		if(br.hasErrors()) {
			List<FieldError> errors=br.getFieldErrors();
			for(FieldError error:errors) {
				err=err+error.getDefaultMessage()+"<br>";
			}
			throw new StudentException(err);	
		}
		try {
			stuService.addStudent(stu);
			return "Student Registered SUCCESSFULLY !";
		}catch(DataIntegrityViolationException ex) {
			throw new StudentException("Please Enter Valid Student Details");
		}
	}
}
