package com.atguigu.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.crud.beans.Employee;
import com.atguigu.crud.dao.EmployeeDao;

@Service("empService")
public class EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;

	public List<Employee> getEmployees() {
		return employeeDao.getAll();
	}

	public Employee getEmployee(Integer id) {
		return employeeDao.get(id);
	}
	public void deleteEmployeeById(Integer id) {
		employeeDao.delete(id);
	}

	public void addEmployee(Employee employee) {
		employeeDao.save(employee);
	}

	public void updateEmployee(Employee employee) {
		employeeDao.update(employee);
	}

}
