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
public class College implements Serializable {

	private static final long serialVersionUID = 6086178798888963771L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="COLLEGE_ID")
	private Long id;
	
	private String name;
	
	@OneToMany(mappedBy="college")
	private List<Professor> professorList = new ArrayList<Professor>(); 

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

	public void setProfessorList(List<Professor> professorList) {
		this.professorList = professorList;
	}

	public List<Professor> getProfessorList() {
		return professorList;
	}
	
}
