package com.login.service;

import java.util.List;

import com.login.entity.Student;
import com.login.exceptions.StudentException;

public interface StudentService {
	boolean addStudent(Student stu);
	String login(String phoneNumber,String password)throws StudentException;
	String updatePassword(Student stu)throws StudentException;
	List getAllStudents();
}
