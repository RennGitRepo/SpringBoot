package com.crud.rest.webservices.restfulwebservices.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.crud.rest.webservices.restfulwebservices.model.Employee;


public interface EmployeeRepository extends MongoRepository<Employee, Integer> {
	
	List <Employee> findByempName(String name);

}
