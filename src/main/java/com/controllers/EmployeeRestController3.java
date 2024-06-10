package com.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dto.EmployeeDTO;
import com.exceptionsHandlers.EmployeeNotFoundException;
import com.exceptionsHandlers.NegativeIdException;
import com.service.EmployeeService;

//on this one we are creating better version of REST API
@RestController
@RequestMapping("/version3") // class //call like this localhost:777/version1/1
public class EmployeeRestController3 {

	@Autowired
	EmployeeService employeeService;

	@GetMapping("/fetchAllEmployees") // on restController we can not use the do the same mapping name so can change
										// it
	// automatically return JSON format here in Rest API
	// return type List<EmployeeDTo
	public ResponseEntity<List<EmployeeDTO>> fetchAllRecords() {

		List<EmployeeDTO> employeeDtoList = employeeService.findAllEmployees();

		return new ResponseEntity<>(employeeDtoList, HttpStatus.OK);// return in a JSON format
		// ok is 200 status it means program is running success
//getting the respose in another application here POSTMAN in a JSON format.
	}

	// fetch the particular record on the basis of ID
	@GetMapping("/fetchParticularRec/{customerId}") // localhost:777/fetchParticularRec/1
	public ResponseEntity<EmployeeDTO> fetchRecordOfEmloyee(@PathVariable int customerId) {// when we use {customerId}
			EmployeeDTO employeeDTO = employeeService.fetchAllRecord(customerId);																				// we should use
			if(employeeDTO !=null) {
				return new ResponseEntity<>(employeeDTO,HttpStatus.OK);
				
			}else {
				throw new EmployeeNotFoundException("Emloyee Does Not EXIT!!!!!!!!!!");
			}
	}

	// Register a user
	@PostMapping("/employeesRegister") // localhost:777/employeesRegister
	public ResponseEntity<String> registerEmployee(@RequestBody EmployeeDTO employeeDTO) {
		employeeService.registerEmp(employeeDTO);
		return new ResponseEntity<>("Reqistered Successfully!!", HttpStatus.CREATED);// 201 created here

	}

	@PutMapping("/employeesUpdate/{customerId}") // localhost:777/employeesUpdate/6
	public ResponseEntity<String> updateEmployee(@RequestBody EmployeeDTO employeeDTO) {
		employeeService.registerEmp(employeeDTO);// here workk as Update becasue we provide customereid

		return new ResponseEntity<>("Update SuccessFully!!!!", HttpStatus.CREATED);

	}

	@DeleteMapping("/employeesDelete/{customerId}") // localhost:777/employeesDelete/1
	public String deleteEmployees(@PathVariable int customerId) {
		//Globally excepption
		if(customerId <=0) {
			throw new NegativeIdException("Customer Id CAN NOT be Negative So Doesn't EXIT!!!");
		}
		
		
		/**
		 * exception locally here
		 */
		try {
			employeeService.deleteEmp(customerId);
			return ("delete Successfully!!");

		} catch (Exception e) {
			return "this Id is not deleted because it does not exit";
		}

	}

}

