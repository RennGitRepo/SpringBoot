package com.crud.rest.webservices.restfulwebservices.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.rest.webservices.restfulwebservices.model.Employee;
import com.crud.rest.webservices.restfulwebservices.model.LeaveActivity;
import com.crud.rest.webservices.restfulwebservices.model.LeaveStatementReq;
import com.crud.rest.webservices.restfulwebservices.model.LeaveStatementResp;
import com.crud.rest.webservices.restfulwebservices.repository.EmployeeRepository;

@Service
public class LeaveServiceImpl implements LeaveService {

	@Autowired
	EmployeeRepository empRepo;

	

	@Override
	public List<LeaveStatementResp> leaveStatement(LeaveStatementReq leaveStateReq) {
		Employee employee = null;
		Optional<Employee> optEmployee = empRepo.findById(leaveStateReq.getEmpID());
		List<LeaveStatementResp> respList = new ArrayList<>();
		if (optEmployee.isPresent()) {

			employee = optEmployee.get();
			List<LeaveActivity> leaveAct = employee.getLeaveActList();

			if (leaveAct != null) {

				for (LeaveActivity leaveActEle : leaveAct) {
					LeaveStatementResp leaveStateResp = new LeaveStatementResp();
					if (leaveStateReq.getFromDate().isBefore(leaveActEle.getDateOfAccrual())
							&& leaveStateReq.getToDate().isBefore(leaveActEle.getDateOfAccrual())) {

						
						
						  if (leaveStateReq.getFromDate().isBefore(leaveActEle.getDateOfUtility()) &&
						  leaveStateReq.getToDate().isBefore(leaveActEle.getDateOfUtility())) {
						 

							leaveStateResp.setAccDateResp(leaveActEle.getDateOfAccrual());
							leaveStateResp.setAccrualDaysResp(leaveActEle.getEmpLeaveAccDays());

							leaveStateResp.setUtiDateResp(leaveActEle.getDateOfUtility());
							leaveStateResp.setUtilizeDaysResp(leaveActEle.getEmpLeaveUtilizeDays());

							respList.add(leaveStateResp);
						}
					}
				}

			}

		}

		return respList;
	}

	@Override
	public Employee leaveAccrual(int empID, int noOfDays) {

		Employee employee = null;
		Optional<Employee> optEmployee = empRepo.findById(empID);
		if (optEmployee.isPresent()) {
			employee = optEmployee.get();
			List<LeaveActivity> leaveActList = employee.getLeaveActList();

			if (leaveActList !=null)

			{
				LeaveActivity leaveActEleTemp = new LeaveActivity();
				for (LeaveActivity leaveActEle : leaveActList) {
					leaveActEleTemp.setLeaveBalance(noOfDays + leaveActEle.getEmpLeaveAccDays());
					leaveActEleTemp.setEmpLeaveAccDays(noOfDays + leaveActEle.getEmpLeaveAccDays());
					leaveActEleTemp.setDateOfAccrual(LocalDateTime.now());
					leaveActEleTemp.setDateOfUtility(LocalDateTime.now());
					leaveActEleTemp.setComment(noOfDays+ " leave days have been accrued!");

				}
				leaveActList.add(leaveActEleTemp);
				employee.setLeaveActList(leaveActList);

			} else {

				List<LeaveActivity> leaveActEle = new ArrayList<LeaveActivity>();
				LeaveActivity leaveActNewEle = new LeaveActivity();

				leaveActNewEle.setEmpLeaveAccDays(noOfDays);
				leaveActNewEle.setLeaveBalance(noOfDays);
				leaveActNewEle.setDateOfAccrual(LocalDateTime.now());
				leaveActNewEle.setDateOfUtility(LocalDateTime.now());
				leaveActNewEle.setComment(noOfDays+ " leave days have been accrued!");
				leaveActEle.add(leaveActNewEle);
				

				employee.setLeaveActList(leaveActEle);

			}
			employee = empRepo.save(employee);

		}

		return employee;
	}

	@Override
	public Employee leaveUtility(int id, int diffInDays) {

		Employee employee = null;
		Optional<Employee> optEmployee = empRepo.findById(id);
		if (optEmployee.isPresent()) {
			employee = optEmployee.get();
			List<LeaveActivity> leaveActList = employee.getLeaveActList();

			if (!leaveActList.isEmpty()) {

				LeaveActivity leaveActEleTemp = new LeaveActivity();
				for (LeaveActivity leaveActEle : leaveActList) {

					int leaveBal = leaveActEle.getLeaveBalance();
					
					int finalLeaveBal = leaveBal - diffInDays;
					leaveActEleTemp.setEmpLeaveAccDays(finalLeaveBal);
					leaveActEleTemp.setLeaveBalance(finalLeaveBal);
					int empUtiDays = leaveActEle.getEmpLeaveUtilizeDays() + diffInDays;
					leaveActEleTemp.setEmpLeaveUtilizeDays(empUtiDays);
					leaveActEleTemp.setDateOfUtility(LocalDateTime.now());
					leaveActEleTemp.setDateOfAccrual(LocalDateTime.now());
					leaveActEleTemp.setComment(diffInDays+ " leave days have been utilized!");

				}
				leaveActList.add(leaveActEleTemp);
				employee.setLeaveActList(leaveActList);
				employee = empRepo.save(employee);

			}

		}
		return employee;
	}

	
}
