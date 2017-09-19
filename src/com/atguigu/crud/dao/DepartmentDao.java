package com.atguigu.crud.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.atguigu.crud.beans.Department;

@Repository
public class DepartmentDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<Department> getDepartments() {
		String sql = "select id, name from dept";
		RowMapper<Department> rowMapper = new BeanPropertyRowMapper<>(Department.class);
		return jdbcTemplate.query(sql, rowMapper);
	}

	public Department getDepartment(Integer id) {
		String sql = "select id, name from dept where id=?";
		RowMapper<Department> rowMapper = new BeanPropertyRowMapper<>(Department.class);
		return jdbcTemplate.queryForObject(sql, rowMapper, id);
	}

}
