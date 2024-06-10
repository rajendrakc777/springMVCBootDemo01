package com.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dto.EmployeeDTO;
import com.service.EmployeeService;

@RestController
@RequestMapping("/version1") //class //call like this localhost:777/version1/1
public class EmployeeRestController {

	@Autowired
	EmployeeService employeeService;

	@GetMapping("/fetchAllEmployees") // on restController we can not use the do the same mapping name so can change
										// it
	// automatically return JSON format here in Rest API
	// return type List<EmployeeDTo
	public List<EmployeeDTO> fetchAllRecords() {
		List<EmployeeDTO> employeeDtoList = employeeService.findAllEmployees();
		return employeeDtoList;// return in a JSON format
//getting the respose in another application here POSTMAN in a JSON format.
	}

	// fetch the particular record on the basis of ID
	@GetMapping("/fetchParticularRec/{customerId}") // localhost:777/fetchParticularRec/1
	public EmployeeDTO fetchRecordOfEmloyee(@PathVariable int customerId) {// when we use {customerId} we should use
																			// @PathVaribale
		EmployeeDTO employeeDto = employeeService.fetchAllRecord(customerId);
		return employeeDto;

	}
	//Register a user
	@PostMapping("/employeesRegister")//localhost:777/employeesRegister
	public String registerEmployee(@RequestBody EmployeeDTO employeeDTO) {
		employeeService.registerEmp(employeeDTO);
		return "Registered Successfully!!!!!";
		
	}
	@PutMapping("/employeesUpdate/{customerId}")//localhost:777/employeesUpdate/6
	public String updateEmployee(@RequestBody EmployeeDTO employeeDTO) {	
	employeeService.registerEmp(employeeDTO);//here workk as Update becasue we provide customereid
	
	return "Update SuccessFully!!!!";
	
}
	@DeleteMapping("/employeesDelete/{customerId}")//localhost:777/employeesDelete/1
public String deleteEmployees(@PathVariable int customerId) {
	employeeService.deleteEmp(customerId);
		
		return "Deleted SuccessFully!!!!!!!";
	}
}

