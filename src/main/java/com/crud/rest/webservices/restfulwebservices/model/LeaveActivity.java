package com.crud.rest.webservices.restfulwebservices.model;

import java.time.LocalDateTime;
import java.util.Date;


public class LeaveActivity {
	
	private int empLeaveAccDays;
	private int empLeaveUtilizeDays;
	private LocalDateTime dateOfAccrual;
	private LocalDateTime dateOfUtility;
	private String comment;
	
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	private int leaveBalance;

	public int getLeaveBalance() {
		return leaveBalance;
	}
	public void setLeaveBalance(int leaveBalance) {
		this.leaveBalance = leaveBalance;
	}
	public LocalDateTime getDateOfAccrual() {
		return dateOfAccrual;
	}
	public void setDateOfAccrual(LocalDateTime dateOfAccrual) {
		this.dateOfAccrual = dateOfAccrual;
	}
	public LocalDateTime getDateOfUtility() {
		return dateOfUtility;
	}
	public void setDateOfUtility(LocalDateTime dateOfUtility) {
		this.dateOfUtility = dateOfUtility;
	}
	
	public LeaveActivity() {
		super();
		// TODO Auto-generated constructor stub
	}
	private int empID;
	
	
	
	public int getEmpLeaveAccDays() {
		return empLeaveAccDays;
	}
	public void setEmpLeaveAccDays(int empLeaveAccDays) {
		this.empLeaveAccDays = empLeaveAccDays;
	}
	public int getEmpLeaveUtilizeDays() {
		return empLeaveUtilizeDays;
	}
	public void setEmpLeaveUtilizeDays(int empLeaveUtilizeDays) {
		this.empLeaveUtilizeDays = empLeaveUtilizeDays;
	}

	public int getEmpID() {
		return empID;
	}
	public void setEmpID(int empID) {
		this.empID = empID;
	}
	public LeaveActivity(int leaveId, int empLeaveAccDays, int empLeaveUtilizeDays, Date dateOfAccrual,
			Date dateOfUtility, int empID) {
		super();
		this.empLeaveAccDays = empLeaveAccDays;
		this.empLeaveUtilizeDays = empLeaveUtilizeDays;

		this.empID = empID;
	}
	@Override
	public String toString() {
		return "LeaveActivity [empLeaveAccDays=" + empLeaveAccDays + ", empLeaveUtilizeDays="
				+ empLeaveUtilizeDays + ", dateOfAccrual=" + dateOfAccrual + ", dateOfUtility=" + dateOfUtility
				+ ", empID=" + empID + "]";
	}
	
	
	
	
	
	

}
