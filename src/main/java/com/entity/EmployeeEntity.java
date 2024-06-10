package com.entity;

import javax.persistence.Entity;




import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


//making it in entity class because it has to communicate with dau layer
 @Entity
@Table (name = "emp_tbl")// for rename use this // emp_tbl database will be created 
public class EmployeeEntity {
	int customerId;
	String customerName;
	String email;
	String phoneNum;
	public EmployeeEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EmployeeEntity(int customerId, String customerName, String email, String phoneNum) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.email = email;
		this.phoneNum = phoneNum;
	}
	@Id  //primary key 
	@GeneratedValue(strategy=GenerationType.AUTO)
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
	public String  getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	@Override
	public String toString() {
		return "EmployeeEntity [customerId=" + customerId + ", customerName=" + customerName + ", email=" + email
				+ ", phoneNum=" + phoneNum + "]";
	}
	
	
}
