package com.login.dao;

import com.login.entity.Student;

public interface StudentDAO {
	boolean addStudent(Student stu);
	boolean checkStudent(String phoneNumber);
	Student getStudent(String phoneNumber);
	Student viewStudent(String phoneNumber);
	String updatePassword(Student stu);
}
