package com.test.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "SHARE")
public class Share implements Serializable {

	private static final long serialVersionUID = 6729757479670893983L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SHARE_ID")
	private Integer id;

	@ElementCollection
	@CollectionTable(name = "OWNER_SHARES", joinColumns = @JoinColumn(name = "SHARE_ID") )
	@Column(name="SHARE_AMOUNT")
	@MapKeyJoinColumn(name = "OWNER_KEY")
	private Map<Owner, Integer> ownerSharesMap = new HashMap<Owner, Integer>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Map<Owner, Integer> getOwnerSharesMap() {
		return ownerSharesMap;
	}

	public void setOwnerSharesMap(Map<Owner, Integer> ownerSharesMap) {
		this.ownerSharesMap = ownerSharesMap;
	}
}
