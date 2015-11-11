package com.test.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="PROFESSOR_DEPARTMENT")
@IdClass(ProfessorDepartmentId.class)
public class ProfessorDepartment implements Serializable {
	
	private static final long serialVersionUID = 8110157366225560935L;
	
	@Id
	@ManyToOne
	@JoinColumn(name="DEPT_ID")
	private Department department;
	
	@Id
	@ManyToOne
	@JoinColumn(name="PROF_ID")
	private Professor professor;
	
	@OneToOne
	@JoinColumn(name="ROLE_ID")
	private Role role;

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Department getDepartment() {
		return department;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Role getRole() {
		return role;
	}
}
