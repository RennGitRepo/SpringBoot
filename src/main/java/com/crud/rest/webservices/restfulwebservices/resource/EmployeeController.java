package com.crud.rest.webservices.restfulwebservices.resource;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.crud.rest.webservices.restfulwebservices.model.Employee;
import com.crud.rest.webservices.restfulwebservices.model.LeaveStatementReq;
import com.crud.rest.webservices.restfulwebservices.model.LeaveStatementResp;
import com.crud.rest.webservices.restfulwebservices.repository.EmployeeRepository;
import com.crud.rest.webservices.restfulwebservices.services.LeaveService;

@RestController

public class EmployeeController {

	@Autowired
	private EmployeeRepository repository;

	@Autowired
	LeaveService leaveService;

	@PostMapping("/addEmployee")
	public String createEmployee(@RequestBody Employee employee) {
		repository.save(employee);
		return "The Employee with id: " + employee.getId();

	}

	@GetMapping("/getAllEmployees")
	public List<Employee> getEmployees() {

		List<Employee> empList = repository.findAll();
		return empList;

	}

	@GetMapping("/getEmployeeByName/{name}")
	public List<Employee> getEmployeesByName(@PathVariable String name) {

		List<Employee> empList = repository.findByempName(name);

		empList = empList.stream().filter(e -> e.getEmpName().equalsIgnoreCase(name)).collect(Collectors.toList());
		if (!empList.isEmpty()) {
			System.out.println("The employee with name: " + name + "is present");
		}
		return empList;
	}

	@PutMapping("/updateEmployee/{id}")
	public String updateEmployee(@RequestBody Employee employee, @PathVariable int id) {
		employee.setId(id);
		repository.save(employee);
		return "The Employee is updated with new ID: " + employee.getId();

	}

	// Leave Accrual
	@PostMapping("addleaves/employee/{id}/leaves/{numDays}")
	public Employee addLeaves(@PathVariable int id, @PathVariable int numDays) {
		return leaveService.leaveAccrual(id, numDays);
		// return leaveService.provideLeave(id, numDays);

	}

	// Leave Utilize
	@DeleteMapping("consumeLeaves/employee/{id}/leaves/{fromDate}/{toDate}")
	public Employee consumeLeaves(@PathVariable int id,
			@PathVariable("fromDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateFrom,
			@PathVariable("toDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateTo) {

		int diffInDays = (int) ((dateTo.getTime() - dateFrom.getTime()) / (1000 * 60 * 60 * 24));

		return leaveService.leaveUtility(id, diffInDays);


	}

	@GetMapping("/employee/{id}/statement/{fromDate}/{toDate}")
	public List<LeaveStatementResp> leaveStatement(@PathVariable int id,
			@PathVariable("fromDate") @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") LocalDateTime dateFrom,
			@PathVariable("toDate") @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") LocalDateTime dateTo) {

		LeaveStatementReq leaveStateReq = new LeaveStatementReq();
		leaveStateReq.setEmpID(id);
		leaveStateReq.setFromDate(dateFrom);
		leaveStateReq.setToDate(dateTo);
		return leaveService.leaveStatement(leaveStateReq);

	}
}
