package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;

@RestController
@RequestMapping(value="/students")
public class StudentController {

	  @Autowired 
	  private StudentService studentService;
	  
	  @PostMapping
	  public Student addCustomer(@RequestBody Student student)
	  {
		  System.out.println("heelloo");
	  return studentService.addStudent(student);
	  }
	  
	  @GetMapping
	  public List<Student> getCustomers()
	  {

		  return studentService.getStudents();
		  }
	  
	  @GetMapping(value = "/studentId") 
	  public Student getCusotmer(@PathVariable("studentId") int studentId)
	  {
		  return  studentService.getStudent(studentId);
	  }

	  @PutMapping(value="/{studentId}")
	  public Student updateCustomer(@PathVariable("studentId") int studentId ,@RequestBody Student student)
	  {
		   return studentService.updateStudent(studentId, student);			  
	  }
	
	  @DeleteMapping(value="/{studentId}")
	  public void deleteCustomer(@PathVariable("studentId")int studentId) 
	  {
	  studentService.deleteStudent(studentId);
	 }
	  

	
}
