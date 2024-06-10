package com.dao;

import java.util.List;
import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.entity.EmployeeEntity;

@Repository // using for database
//we use extends keyword for two interfaces not implements
//JpaResository is also interface.
public interface EmployeeDao extends JpaRepository<EmployeeEntity, Integer> {
//doesn't matter object will null or not null put into Optional container
	Optional<EmployeeEntity> findByCustomerIdAndCustomerName(int customerId, String customerName);
	List<EmployeeEntity> findAll();
	
}