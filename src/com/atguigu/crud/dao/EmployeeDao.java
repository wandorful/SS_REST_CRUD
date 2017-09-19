package com.atguigu.crud.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.atguigu.crud.beans.Employee;

@Repository
public class EmployeeDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private DepartmentDao departmentDao;

	public void save(Employee emp) {
		String sql = "insert into emp(last_name, email, gender, dept_id) values(?, ?, ?, ?)";
		jdbcTemplate.update(sql, emp.getLastName(), emp.getEmail(), emp.getGender(), emp.getDeptId());
	}

	public void update(Employee emp) {
		String sql = "update emp set email = ?, dept_id = ? where id = ?";
		jdbcTemplate.update(sql, emp.getEmail(), emp.getDeptId(), emp.getId());
	}

	public List<Employee> getAll() {
		String sql = "select id, last_name lastName, email, gender, dept_id deptId from emp";
		RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<>(Employee.class);
		List<Employee> employees = jdbcTemplate.query(sql, rowMapper);
		for (Employee employee : employees) {
			employee.setDepartment(departmentDao.getDepartment(employee.getDeptId()));
		}
		return employees;
	}

	public Employee get(Integer id) {
		String sql = "select id, last_name lastName, email, gender, dept_id deptId from emp where id = ?";
		RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<>(Employee.class);
		return jdbcTemplate.queryForObject(sql, rowMapper, id);
	}

	public void delete(Integer id) {
		String sql = "delete from emp where id = ?";
		jdbcTemplate.update(sql, id);
	}
}
