package com.controllers;


import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dto.EmployeeDTO;
import com.service.EmployeeService;


//this is my dev branch
//merge main branch into dev branch here
@Controller
public class EmployeeController {
	
	@Autowired 
	EmployeeService employeeService;
	
	@GetMapping({"/login","/"})
	public String callLogInPage() {
		return "login";
	}
	
	@GetMapping("/register")
	public String callRegistrationPage() {
		return "registration";
	}
	
	@PostMapping("/registration")
	public String registerEmployee(@ModelAttribute EmployeeDTO employeeDTO, Model model) {
		//@RequestParam -->4times so alternative we can use @ModelAttribute EmploeeDTO employeedto
		//employeedto object hold the 4 datas.
		employeeService.registerEmp(employeeDTO);
		//we can make any method here like registerEmp forward employeeDTO to service layer first
		model.addAttribute("msg", "Record Inserted Successfully!!!!!");
		return "registration";
		
		
	}
	
	@PostMapping("/loginValidate")
		public String authenticate(@RequestParam int customerId, @RequestParam String customerName, Model model) {
		//for validateion purpose we can forward this two value to the service layer.	
		//we can write any method here like: authenticate use here.
		EmployeeDTO employeeDTO=employeeService.authenticate(customerId,customerName);
			
	if (employeeDTO!=null) {
		//true/valide
		model.addAttribute("employeeDTO", employeeDTO);
		return "congratulation";
		
	}else {
		//false/not null
		model.addAttribute("message", "Wrong credential retry");
		return"login";
		
		}
		
	}
	@GetMapping("/fetchAll")
	public String fetchAllRecords(Model model) {
		List<EmployeeDTO> employeeDtoList=employeeService.findAllEmployees();
		model.addAttribute("employeeDtoList", employeeDtoList);
		return "showAll";
	}
	
	//delete operation
	@GetMapping ("/deleteEmployee")
	public String deleteEmployee(@RequestParam int customerId, Model model) {
		employeeService.deleteEmp(customerId);//forwarded to service layer
		model.addAttribute("message", "Records Deleted Success!!!");
		return "redirect:/fetchAll";//using redirect cll the fetchAll and show the remaingn data after deletion operation
		
	}
	//edit operation
	@GetMapping("/updateEmployee")
	public String updateEmp(@RequestParam int customerId, Model model) {
		EmployeeDTO employeeDTO=employeeService.fetchAllRecord(customerId);
		model.addAttribute("employeeDTO", employeeDTO);
		return "updateEmployee";
	}
	
	//edit operation
	@PostMapping("/updateEmp")
	public String updateButton(@ModelAttribute EmployeeDTO employeeDTO, Model model) {
		employeeService.updateEmp(employeeDTO);
		return "updateEmployee";
	}
}


