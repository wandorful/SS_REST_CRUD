package com.atguigu.crud.beans;

public class Department {

	private Integer id;
	private String name;

	public Department() {
	}

	public Department(int i, String string) {
		this.id = i;
		this.name = string;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String departmentName) {
		this.name = departmentName;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", departmentName=" + name + "]";
	}
	
}
