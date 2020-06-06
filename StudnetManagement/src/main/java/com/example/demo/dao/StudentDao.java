package com.example.demo.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Student;

@Repository
public interface StudentDao extends CrudRepository<Student, Integer> 
{

	@Override
	public List<Student> findAll();
}
