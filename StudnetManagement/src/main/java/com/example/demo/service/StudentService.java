package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.StudentDao;
import com.example.demo.exception.StudentNotFoundException;
import com.example.demo.model.Student;

@Service
public class StudentService {

	@Autowired
	private StudentDao studentdao;
	
	public Student addStudent(Student student)
	{
		return studentdao.save(student);
	}
	
	public List<Student> getStudents(){
		return studentdao.findAll();
	}
	public Student getStudent(int studentId)
	
	{
	
		Optional<Student>  optionalStudent= studentdao.findById(studentId);
		
		if (optionalStudent.isPresent())
		{
			throw new StudentNotFoundException("student not avlilable");
		}
		return studentdao.findById(studentId).get();
	}
	
	public Student updateStudent(int studentId , Student student)
	{
		student.setStudentId(studentId);
		
		return studentdao.save(student);
	}
	
	
	public void  deleteStudent(int studentId)
	{
		studentdao.deleteById(studentId);
	}
	
}