package com.crud.rest.webservices.restfulwebservices.model;

import java.time.LocalDateTime;

public class LeaveStatementResp {

	private int accrualDaysResp;
	private int utilizeDaysResp;
	private LocalDateTime accDateResp;
	private LocalDateTime utiDateResp;
	public int getAccrualDaysResp() {
		return accrualDaysResp;
	}
	public void setAccrualDaysResp(int accrualDaysResp) {
		this.accrualDaysResp = accrualDaysResp;
	}
	public int getUtilizeDaysResp() {
		return utilizeDaysResp;
	}
	public void setUtilizeDaysResp(int utilizeDaysResp) {
		this.utilizeDaysResp = utilizeDaysResp;
	}
	public LocalDateTime getAccDateResp() {
		return accDateResp;
	}
	public void setAccDateResp(LocalDateTime accDateResp) {
		this.accDateResp = accDateResp;
	}
	public LocalDateTime getUtiDateResp() {
		return utiDateResp;
	}
	public void setUtiDateResp(LocalDateTime utiDateResp) {
		this.utiDateResp = utiDateResp;
	}
	
	
}
