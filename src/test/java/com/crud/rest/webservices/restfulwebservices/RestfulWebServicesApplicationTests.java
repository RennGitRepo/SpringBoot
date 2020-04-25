package com.crud.rest.webservices.restfulwebservices;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.crud.rest.webservices.restfulwebservices.model.Employee;
import com.crud.rest.webservices.restfulwebservices.repository.EmployeeRepository;
import com.crud.rest.webservices.restfulwebservices.resource.EmployeeController;

@RunWith(SpringRunner.class)
@SpringBootTest
class RestfulWebServicesApplicationTests {

	@Autowired
	EmployeeController controller;
	
	@MockBean
	private EmployeeRepository repository; 
	
	
	@Test
	public void getEmployeesTest()
	{
		//Positive UT Case
		when(repository.findAll()).thenReturn(Stream.of(new Employee(100, "Renn", "123456789",
				"renn@abc.com", 5, null), new Employee(101, "ABCC", "2345431", "ABC@abc.com",
						4, null)).collect(Collectors.toList()));
		assertEquals(2, controller.getEmployees().size());
		
	}
	
	@Test
	public void getEmployeesByNameTest() {
		
		//Negative UT Case
		String name="Ruby";
		when(repository.findByempName(name)).thenReturn(Stream.of(new Employee(100, "Renn", "123456789",
				"renn@abc.com", 5, null), new Employee(101, "ABCC", "2345431", "ABC@abc.com",
						4, null)).collect(Collectors.toList()));
		assertEquals(2, controller.getEmployeesByName(name));
	}

}
