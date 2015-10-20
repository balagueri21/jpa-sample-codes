package com.test.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SqlResultSetMapping(name = "StudentMapping", classes = { @ConstructorResult(targetClass = Student.class, columns = {
		@ColumnResult(name = "name", type = String.class), @ColumnResult(name = "address", type = String.class),
		@ColumnResult(name = "date_of_birth", type = Date.class) }) })
@Entity
@Table(name = "STUDENT")
public class Student implements Serializable {

	private static final long serialVersionUID = 3579916431402863799L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private String name;
	private String address;
	@Temporal(TemporalType.DATE)
	@Column(name = "DATE_OF_BIRTH")
	private Date dateOfBirth;

	public Student () {}

    public Student(String name, String address, Date dateOfBirth) {
        this.name = name;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
    }
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
}
