package com.test.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="OWNER")
public class Owner implements Serializable {
	
	private static final long serialVersionUID = 3982431961731408656L;

	@Id
	@Column(name="OWNER_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
