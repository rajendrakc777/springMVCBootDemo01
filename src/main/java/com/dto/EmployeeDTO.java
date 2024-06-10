package com.dto;
//we are using same attributes in EmployeeDTO becasue of we can populating the data
//from one layer to another layer
//so that we can copy from entity to DTO or DTO to Entitry.
public class EmployeeDTO {
	int customerId;
	String customerName;
	String email;
	String phoneNum;
	public EmployeeDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EmployeeDTO(int customerId, String customerName, String email, String phoneNum) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.email = email;
		this.phoneNum = phoneNum;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	@Override
	public String toString() {
		return "EmployeeDTO [customerId=" + customerId + ", customerName=" + customerName + ", email=" + email
				+ ", phoneNum=" + phoneNum + "]";
	}
	
	

}
