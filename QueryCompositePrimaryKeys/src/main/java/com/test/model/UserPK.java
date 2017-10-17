package com.test.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class UserPK implements Serializable {
    @Column(name = "id")
    private Long id;

    @Column(name = "\"group\"")
    private String group;
    
    public UserPK(Long id, String group) {
    	this.id = id;
    	this.group = group;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

    
}
