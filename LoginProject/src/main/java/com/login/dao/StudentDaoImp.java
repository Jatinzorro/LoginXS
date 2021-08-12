package com.login.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.login.entity.Student;
@Repository
public class StudentDaoImp implements StudentDAO {
	@PersistenceContext
	private  EntityManager em;
	
	
	@Override
	public boolean addStudent(Student stu) {
		em.persist(stu);
		return true;
	}

	@Override
	public boolean checkStudent(String phoneNumber) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Student getStudent(String phoneNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student viewStudent(String phoneNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updatePassword(Student stu) {
		// TODO Auto-generated method stub
		return null;
	}

}
