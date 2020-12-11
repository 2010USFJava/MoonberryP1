package com.revature.dao;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.revature.model.Employee;
import com.revature.model.Event_Type;
import com.revature.model.Grade_Format;
import com.revature.model.TR_Request;

public interface EmployeeDao {
	//TODO save files to database
	public void makeRequest(TR_Request tr);
	
	public boolean isSuperAlsoDptHead(Employee e);
	
	public Employee findById(int id);
	
	public Employee findByUsername(String username);
	
	public List<Employee> findAll();
	
	public Employee findByRequest(TR_Request r);
	
	public List<TR_Request> findEmployeeRequests(Employee e);
	
	public void insert(Employee e);
	public void update(Employee e, double newAvailRmbsment);

	
	
}
