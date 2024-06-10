package com.service;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.dao.EmployeeDao;
import com.dto.EmployeeDTO;
import com.entity.EmployeeEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional // by using this annotation it should be executed within the database.
public class EmployeeServiceImp1 implements EmployeeService {

	@Autowired
//Service layer communicate with Dao layer
	EmployeeDao employeeDao;

	@Override
	public void registerEmp(EmployeeDTO employeeDTO) {
		EmployeeEntity employeeEntity = new EmployeeEntity();
		// copy employeeDTO to employeeEntity
		BeanUtils.copyProperties(employeeDTO, employeeEntity);// employeeEntity object will be saved in table as a
																// record.
		employeeDao.save(employeeEntity);
		// this save method create one table. 4 data will save on db.
	}

	@Override
	public EmployeeDTO authenticate(int customerId, String customerName) {
		// two customerid and customerName are forwarded to Dao layer.
		Optional<EmployeeEntity> optional = employeeDao.findByCustomerIdAndCustomerName(customerId, customerName);
		// service layer use employoeeDTO
		EmployeeDTO employeeDTO = null;
		if (optional.isPresent()) {
			// valid
			EmployeeEntity employeeEntity = optional.get();
			employeeDTO = new EmployeeDTO();
			// copy from empEntity to employeeDTO
			// how to copy like this
			BeanUtils.copyProperties(employeeEntity, employeeDTO);
			return employeeDTO;// not null
		} else {
			// for false condition -->if record not found
			return employeeDTO;// null
		}
	}

	@Override
	public List<EmployeeDTO> findAllEmployees() {
		// here collection of records in employeeEntity
		List<EmployeeEntity> employeeEntity = employeeDao.findAll();

		List<EmployeeDTO> employeeDtoList = new ArrayList<>();// blank arrylist
		// copy the data from Emppoyee to EmployeeDTo
		if (employeeEntity.size() > 0) {
			// if conditioon is true 1st object will copy to temmp here
			for (EmployeeEntity temp : employeeEntity) {// belonging class name and temp: whom we want to iterate

				EmployeeDTO employeeDTO = new EmployeeDTO();
				// copy from temp to employeeDTO object
				BeanUtils.copyProperties(temp, employeeDTO);
				// 1st object will copied from temp to employeeDTO.
				employeeDtoList.add(employeeDTO);// in first iteration first object will added in blank arrayList

			}
		}

		return employeeDtoList;// employeeDto-->it is a collection of records in the form of objects.
	}

	// delete operation
	// here we can perform delete operation. which method come from controller and
	// forwarded to service layer
	@Override
	public void deleteEmp(int customerId) {
		employeeDao.deleteById(customerId);

	}

// fetch the data on edit form update Empoyee.
	@Override
	public EmployeeDTO fetchAllRecord(int customerId) {
		Optional<EmployeeEntity> optional = employeeDao.findById(customerId);
		EmployeeDTO employeeDTO = null;
		if (optional.isPresent()) {
			EmployeeEntity employeeEntity = optional.get();
			employeeDTO = new EmployeeDTO();// object create
			// copy from employeeEntity to employeeDTO
			// sourc is employeeEntity and target is employeeDTO
			BeanUtils.copyProperties(employeeEntity, employeeDTO);
			return employeeDTO;
		} else {

			return employeeDTO;// this object will forward to controller.
		}
	}

	@Override
	public void updateEmp(EmployeeDTO employeeDTO) {
		EmployeeEntity employeeEntity = new EmployeeEntity();
		BeanUtils.copyProperties(employeeDTO, employeeEntity);
		employeeDao.save(employeeEntity);		
	}
}
