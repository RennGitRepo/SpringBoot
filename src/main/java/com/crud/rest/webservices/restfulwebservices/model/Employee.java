package com.crud.rest.webservices.restfulwebservices.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.ToString;

@ToString
@Document(collection = "Employee")

public class Employee {

	@Id
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpMobileNo() {
		return empMobileNo;
	}

	public void setEmpMobileNo(String empMobileNo) {
		this.empMobileNo = empMobileNo;
	}

	public String getEmpEmailId() {
		return empEmailId;
	}

	public void setEmpEmailId(String empEmailId) {
		this.empEmailId = empEmailId;
	}

	public int getEmpLeaveBalance() {
		return empLeaveBalance;
	}

	public void setEmpLeaveBalance(int empLeaveBalance) {
		this.empLeaveBalance = empLeaveBalance;
	}

	private String empName;
	private String empMobileNo;
	private String empEmailId;
	private int empLeaveBalance;
	
	private List<LeaveActivity> leaveActList;
	
	public List<LeaveActivity> getLeaveActList() {
		return leaveActList;
	}

	public void setLeaveActList(List<LeaveActivity> leaveActList) {
		this.leaveActList = leaveActList;
	}

	private LeaveActivity leaveAct;

	public LeaveActivity getLeaveAct() {
		return leaveAct;
	}

	public void setLeaveAct(LeaveActivity leaveAct) {
		this.leaveAct = leaveAct;
	}

	public Employee(int id, String empName, String empMobileNo, String empEmailId, int empLeaveBalance,
			LeaveActivity leaveAct) {
		super();
		this.id = id;
		this.empName = empName;
		this.empMobileNo = empMobileNo;
		this.empEmailId = empEmailId;
		this.empLeaveBalance = empLeaveBalance;
		this.leaveAct = leaveAct;
	}
	



}
