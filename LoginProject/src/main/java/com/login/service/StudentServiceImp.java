package com.login.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.login.dao.StudentDAO;
import com.login.entity.Student;
@Transactional
@Service
public class StudentServiceImp implements StudentService {
	@Autowired
	private StudentDAO dao;
	
	
	/*This methodwill call the dao for adding a new Student */
	@Override
	public boolean addStudent(Student stu) {
		
		return dao.addStudent(stu);
	}

	
	
	@Override
	public String login(String phoneNumber, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updatePassword(Student stu) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List getAllStudents() {
		// TODO Auto-generated method stub
		return null;
	}

}
