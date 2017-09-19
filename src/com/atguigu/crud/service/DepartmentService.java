package com.atguigu.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.crud.beans.Department;
import com.atguigu.crud.dao.DepartmentDao;

@Service("deptService")
public class DepartmentService {

	@Autowired
	private DepartmentDao departmentDao;

	public List<Department> getDepts() {
		return departmentDao.getDepartments();
	}
}
