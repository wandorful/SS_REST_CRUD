package com.atguigu.crud.handler;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.atguigu.crud.beans.Employee;
import com.atguigu.crud.service.DepartmentService;
import com.atguigu.crud.service.EmployeeService;

@Controller
public class EmployeeHandler {

	@Autowired
	private EmployeeService empService;
	@Autowired
	private DepartmentService deptService;

	// 获取所有员工的信息
	@RequestMapping(value="/emps", method=RequestMethod.GET)
	public String getAllEmployees(Map<String, Object> map) {
		map.put("emps", empService.getEmployees());
		return "list";
	}

	// 删除员工信息
	@RequestMapping(value="/emp/{id}", method=RequestMethod.DELETE)
	public String deleteEmployee(@PathVariable("id") Integer id) {
		empService.deleteEmployeeById(id);
		return "redirect:/emps";
	}

	@RequestMapping(value="/emp", method=RequestMethod.GET)
	public String toInput(Map<String, Object> map) {
		map.put("employee", new Employee());
		map.put("depts", deptService.getDepts());
		return "input";
	}

	// 添加员工信息
	@RequestMapping(value="/emp", method=RequestMethod.POST)
	public String addEmployee(Employee employee) {
		empService.addEmployee(employee);
		return "redirect:/emps";
	}

	@RequestMapping(value="/emp/{id}", method=RequestMethod.GET)
	public String toEdit(@PathVariable("id") Integer id, Map<String, Object> map) {
		map.put("employee", empService.getEmployee(id));
		map.put("depts", deptService.getDepts());
		return "edit";
	}

	@ModelAttribute
	public void getEmp(@RequestParam(value="id", required=false) Integer id, Map<String, Object> map) {
		if(id != null) {
			map.put("employee", empService.getEmployee(id));
		}
	}

	// 跟新员工信息
	@RequestMapping(value="/emp", method=RequestMethod.PUT)
	public String updateEmployee(Employee employee) {
		empService.updateEmployee(employee);
		return "redirect:/emps";
	}
}
