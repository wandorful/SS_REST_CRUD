package com.atguigu.crud.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.atguigu.crud.beans.Department;
import com.atguigu.crud.beans.Employee;
import com.atguigu.crud.dao.DepartmentDao;
import com.atguigu.crud.service.EmployeeService;

public class DBTest {

	private ApplicationContext ioc = new ClassPathXmlApplicationContext("beans.xml");
	private DepartmentDao deptDao = (DepartmentDao) ioc.getBean("departmentDao");
	private EmployeeService empService = (EmployeeService) ioc.getBean("empService");

	@Test
	public void test() {
		List<Employee> list = empService.getEmployees();
		for (Employee employee : list) {
			System.out.println(employee);
		}
		List<Department> departments = deptDao.getDepartments();
		for (Department department : departments) {
			System.out.println(department);
		}
	}

	@Test
	public void testAdd() {
		Employee emp = new Employee();
		emp.setLastName("刘明");
		emp.setEmail("lm@gmail.com");
		emp.setGender(1);
		emp.setDeptId(1);
		empService.addEmployee(emp);
	}
}
