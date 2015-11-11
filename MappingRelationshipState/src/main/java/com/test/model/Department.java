package com.test.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Department implements Serializable {
	
	private static final long serialVersionUID = -1925549702577938292L;

	@Id
	@Column(name="DEPT_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	@OneToMany(mappedBy="department")
	private List<ProfessorDepartment> profDepartmentList = new ArrayList<ProfessorDepartment>();

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setProfDepartmentList(List<ProfessorDepartment> profDepartmentList) {
		this.profDepartmentList = profDepartmentList;
	}

	public List<ProfessorDepartment> getProfDepartmentList() {
		return profDepartmentList;
	}
}
