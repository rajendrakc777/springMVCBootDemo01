package com.service;

import java.util.List;


import com.dto.EmployeeDTO;

public interface EmployeeService {

	void registerEmp(EmployeeDTO employeeDTO);

// POJO class for service layer so we can use here EmployeeDTO
	EmployeeDTO authenticate(int customerId, String customerName);

	List<EmployeeDTO> findAllEmployees();// service layers use alwasys EmployeeDTO

	void deleteEmp(int customerId);

	EmployeeDTO fetchAllRecord(int customerId);

	void updateEmp(EmployeeDTO employeeDTO);

}
