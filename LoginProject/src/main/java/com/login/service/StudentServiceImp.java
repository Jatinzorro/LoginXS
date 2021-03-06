package com.login.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.login.dao.StudentDAO;
import com.login.entity.Student;
import com.login.exceptions.StudentException;
@Transactional
@Service
public class StudentServiceImp implements StudentService {
	@Autowired
	private StudentDAO dao;
	
	
	/*This method will call the DAO for adding a new Student */
	@Override
	public boolean addStudent(Student stu)throws StudentException {
		if(dao.checkStudent(stu.getPhoneNumber())==true) {
			throw new StudentException("Student Already Exist, Plz Enter the new phoneNumber for registrartion");
		}
		return dao.addStudent(stu);
	}

	
	
	
	
	/*This Method will call the StudentDao to  check weather the user exist and
	 * it also check the  login credentials matches or not
	 */
	
	@Override
	public String login(String phoneNumber, String password) throws StudentException{
		if(dao.checkStudent(phoneNumber)==false) {
			throw new StudentException("Student Doesnt Exist, Plz Enter the registered phoneNumber");
		}
		Student stu=dao.getStudent(phoneNumber);
		if(stu.getPassword().equals(password)==false) {
			throw new StudentException("Password Doesnt Match/Wrong Password");
		}
		System.out.println("Logged IN Successfully with phone Number: "+stu.getPhoneNumber());
		return "Welcome Student "+ stu.getPhoneNumber() +" You Have Been SUCCESSFULLY Logged IN";
	}

	
	
	
	
	/*Update Functionality
	 * To  Update the password of Student, throws exception if student not there in database
	 */
	
	//Helper MEthod for Update Method, returns the Student Object of Provided Phone Number
	public Student viewStudent(String phoneNumber) {
		return dao.viewStudent(phoneNumber);
	}
	@Override
	public String updatePassword(Student stu) throws StudentException{
		String phoneNumber=stu.getPhoneNumber();
		Student student1=viewStudent(phoneNumber);
		if(student1!=null) {
			dao.updatePassword(stu);
			return "Password Updated SUCCESSFULLY!";
		}else {
			throw new StudentException("This Phone Number Is Not Present In Database");
		}
	}

	

}
