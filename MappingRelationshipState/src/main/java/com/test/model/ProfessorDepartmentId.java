package com.test.model;

import java.io.Serializable;

public class ProfessorDepartmentId implements Serializable {

	private static final long serialVersionUID = -8404380047203320847L;

	private Long department;
	
	private Long professor;

	public void setDepartment(Long department) {
		this.department = department;
	}

	public Long getDepartment() {
		return department;
	}

	public void setProfessor(Long professor) {
		this.professor = professor;
	}

	public Long getProfessor() {
		return professor;
	}
}
