package com.atos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atos.dao.EmpDao;
import com.atos.model.Employee;

@Service
public class EmpService {

	@Autowired
	private EmpDao dao;

	public List<Employee> listEmployeess() {

		return dao.listEmployeess();
	}

	public Employee getEmployee(int empid) {
		return dao.getEmployee(empid);
	}

	public int storeEmp(Employee emp) {
		return dao.addEmployee(emp);

	}

}
