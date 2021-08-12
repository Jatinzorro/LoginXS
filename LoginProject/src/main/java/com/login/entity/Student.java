package com.login.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name="all_Students")
public class Student {
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="student_seq")
	private int studentId;
	
	@NotEmpty(message="Student Name Is Mandatory")
	@Size(min=2,max=20,message="length can be between 2 And 20")
	@Pattern(regexp="([A-Za-z]+)|([A-Za-z]+[ ][A-Za-z]+)",message=": Only Alphabets and one space is allowed")
	private String studentName;
	
	@NotEmpty(message="password is mandatory")
	@Pattern(regexp="^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,14}$", message=": Password must contain one number,one alphabet,one special character and size should be at least 8 and not more than 14 characters")
	private String password;
	
	@Column(unique = true)
	@Pattern(regexp="[1-9][0-9]{9}", message=": Phone number must contain 10 digits")
	@Id
	private String phoneNumber;
	
	@Column
	@NotEmpty(message="email id is mandatory")
	@Email
	private String email;

	public Student() {
		super();
	}

	
	public Student(int studentId,
			@NotEmpty(message = "Student Name Is Mandatory") @Size(min = 2, max = 20, message = "length can be between 2 And 20") @Pattern(regexp = "([A-Za-z]+)|([A-Za-z]+[ ][A-Za-z]+)", message = ": Only Alphabets and one space is allowed") String studentName,
			@NotEmpty(message = "password is mandatory") @Pattern(regexp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,14}$", message = ": Password must contain one number,one alphabet,one special character and size should be at least 8 and not more than 14 characters") String password,
			@Pattern(regexp = "[1-9][0-9]{9}", message = ": Phone number must contain 10 digits") String phoneNumber,
			@NotEmpty(message = "email id is mandatory") @Email String email) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}


	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	@Override
	public String toString() {
		return "Student:: [studentId=" + studentId + ", studentName=" + studentName + ", password=" + password
				+ ", phoneNumber=" + phoneNumber + ", email=" + email + "]";
	}
	
	

}
