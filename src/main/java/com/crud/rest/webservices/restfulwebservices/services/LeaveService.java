package com.crud.rest.webservices.restfulwebservices.services;

import java.util.List;

import com.crud.rest.webservices.restfulwebservices.model.Employee;
import com.crud.rest.webservices.restfulwebservices.model.LeaveStatementReq;
import com.crud.rest.webservices.restfulwebservices.model.LeaveStatementResp;

public interface LeaveService  {
	
	
	public List<LeaveStatementResp> leaveStatement(LeaveStatementReq leaveStateReq);
	
	public Employee leaveAccrual(int empID, int noOfDays );

	public Employee leaveUtility(int id, int diffInDays);

}
