package com.test.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Professor implements Serializable {

	private static final long serialVersionUID = 3325216755270223653L;
	
	@Id
	@Column(name="PROF_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	@OneToMany(mappedBy="professor")
	private List<ProfessorDepartment> profDepartmentList = new ArrayList<ProfessorDepartment>();
	
	@ManyToOne
	@JoinColumn(name="COLLEGE_ID")
	private College college;

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

	public void setCollege(College college) {
		this.college = college;
	}

	public College getCollege() {
		return college;
	}

}
