package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.demo.exception.ApplicationError;
import com.example.demo.exception.StudentNotFoundException;

@ControllerAdvice
@RestController
public class ErrorHandler  extends ResponseEntityExceptionHandler{

	@Value("${api_doc_url}")
	private String details;
	@ExceptionHandler(StudentNotFoundException.class)
	public ResponseEntity<ApplicationError> handleStudentNotFoundExceptions(StudentNotFoundException exception ,WebRequest webRequest)
	{
		ApplicationError error=new ApplicationError();
		error.setCode(101);
		error.setMessage(exception.getMessage());;
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
		
	}
	
}
