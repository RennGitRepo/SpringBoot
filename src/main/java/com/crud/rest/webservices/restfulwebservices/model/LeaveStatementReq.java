package com.crud.rest.webservices.restfulwebservices.model;

import java.time.LocalDateTime;

public class LeaveStatementReq {
	
	
	private int empID;
	private LocalDateTime fromDate;
	private LocalDateTime toDate;
	public int getEmpID() {
		return empID;
	}
	public void setEmpID(int empID) {
		this.empID = empID;
	}
	public LocalDateTime getFromDate() {
		return fromDate;
	}
	public void setFromDate(LocalDateTime fromDate) {
		this.fromDate = fromDate;
	}
	public LocalDateTime getToDate() {
		return toDate;
	}
	public void setToDate(LocalDateTime toDate) {
		this.toDate = toDate;
	}
	

}
