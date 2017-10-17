package com.test.model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class User implements Serializable {
	@EmbeddedId
	private UserPK userPK;

	public UserPK getUserPK() {
		return userPK;
	}

	public void setUserPK(UserPK userPK) {
		this.userPK = userPK;
	}
	
	@Override
	public String toString() {
		return "ID: " + getUserPK().getId() + " | GROUP: " + getUserPK().getGroup();
	}
}
