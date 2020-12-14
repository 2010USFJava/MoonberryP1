package com.revature.service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import com.revature.dao.ApproverDao;
import com.revature.dao.EmployeeDao;
import com.revature.daoimpl.ApproverDaoImpl;
import com.revature.daoimpl.EmployeeDaoImpl;
import com.revature.model.Employee;
import com.revature.model.Event_Type;
import com.revature.model.Grade_Format;
import com.revature.model.RS;
import com.revature.model.TR_Request;
import com.revature.util.LogThis;

public class FormService {
	
	EmployeeDao eDao = new EmployeeDaoImpl();
	ApproverDao adao = new ApproverDaoImpl();
	
	public void makeTRMSRequest(Employee employee, LocalDateTime requestMadeDate, double tuitionAmount,
			LocalDateTime eventStartDate, LocalDateTime eventEndDate, String eventName, String eventLocation,
			String eventDescription, Grade_Format gradeFormat, Event_Type eventType, String workJust, boolean emailProvided) {
		System.out.println("make request in formservice called!");
		
		
		double projectedRmbsment = Math.min(tuitionAmount * eventType.getRmbsmentCoverage(),
			employee.getAvailRmbsment());
		long daysUntilStart = requestMadeDate.until(eventStartDate, ChronoUnit.DAYS);
		if (daysUntilStart < 7) {
			//TODO: should not allow this in javascript
			return;
		}
		boolean urgent = (daysUntilStart < 14);	
		RS requestStatus = RS.AWAIT_SUPER_APPROVAL;
		if (emailProvided)
			requestStatus = RS.AWAIT_BENCO_APPROVAL;
		else {
			if (eDao.isSuperAlsoDptHead(employee))
			requestStatus = RS.AWAIT_DPT_HEAD_APPROVAL;
		else 
			requestStatus = RS.AWAIT_SUPER_APPROVAL;
		double newAvailRmbsment = employee.getAvailRmbsment() - projectedRmbsment;
		employee.setAvailRmbsment(newAvailRmbsment);		
		eDao.update(employee, newAvailRmbsment);
		TR_Request request = new TR_Request(-1, requestStatus, employee.getEmployeeId(), requestMadeDate, 
				eventStartDate, eventEndDate, eventName, eventLocation, eventDescription, tuitionAmount,
				projectedRmbsment, gradeFormat, eventType, workJust, urgent, requestMadeDate);
		eDao.makeRequest(request);
		LogThis.LogIt("info", employee.getEmployeeId() + " submitted a trms request.");
	}
		
	}
	//TODO action date how?
	public void action (int rsid, int id, LocalDateTime ld) {
		TR_Request tr = adao.getRequestById(id);
		RS rs = RS.valueOfStatusCode(rsid);
		adao.setApprovalStatus(rs, tr, ld);
		LogThis.LogIt("info", "Request "+ id + " was changed to status " + rs.toString());
		
	}
}
