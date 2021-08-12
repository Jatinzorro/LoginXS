package com.login.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

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

	
	
	/*Below given 2 methods will Check the existing student in table And return to Service Class*/
	
	@Override
	public boolean checkStudent(String phoneNumber) {
		String Qstr="SELECT  student.phoneNumber FROM Student student WHERE student.phoneNumber= :phoneNumber";
		TypedQuery<String> query=em.createQuery(Qstr, String.class).setParameter("phoneNumber",phoneNumber);
		try {
			String ph=query.getSingleResult();
			ph.equals(phoneNumber);
		}catch(Exception e){
			return  false;
		}
		return true;
	}
	//This method return the Student Object fetched from database and return to Service
	@Override
	public Student getStudent(String phoneNumber) {
		String Qstr="SELECT student FROM Student student WHERE student.phoneNumber= :phoneNumber";
		TypedQuery<Student> query=em.createQuery(Qstr,Student.class).setParameter("phoneNumber",phoneNumber);
		
		return query.getSingleResult();
	}

	
	
	
	/*Update Functionality
	 * Below given methods update the student password given in the DATABASE
	 */
	//Helper Method For Update Functionality: It return the Student whose phone number is given
	
	public List<Student> viewStudent() {
		Query query=em.createQuery("from Student s");
		return query.getResultList();
	}
	
	@Override
	public Student viewStudent(String phoneNumber) {
		List<Student> list =viewStudent();
		Student student=null;
		Optional <Student> optional=list.stream().filter(s1->s1.getPhoneNumber().equals(phoneNumber)).findFirst();
		
		if(optional.isPresent()) {
			student=optional.get();
		}
		return student;
	}
	@Override
	public String updatePassword(Student stu) {
		em.merge(stu);
		return "Updated SUCCESSFULLY!";
	}

}
