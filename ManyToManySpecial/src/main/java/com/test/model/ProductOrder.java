package com.test.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="PRODUCT_ORDER")
@IdClass(ProductOrderId.class)
public class ProductOrder implements Serializable {
	
	private static final long serialVersionUID = 5493754296397155185L;
	
	@Id
	@ManyToOne
	@JoinColumn(name="ORDER_ID")
	private Order order;
	
	@Id
	@ManyToOne
	@JoinColumn(name="PRODUCT_ID")
	private Product product;
	
	@ManyToMany
	@JoinTable(name="PRODUCT_ORDER_ADDRESS",
			joinColumns={@JoinColumn(name="ORDER_ID", referencedColumnName="ORDER_ID"),
					@JoinColumn(name="PRODUCT_ID", referencedColumnName="PRODUCT_ID")},
			inverseJoinColumns=@JoinColumn(name="ADDRESS_ID", referencedColumnName="ADDRESS_ID"))
	private List<Address> addressList = new ArrayList<Address>();

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public List<Address> getAddressList() {
		return addressList;
	}

	public void setAddressList(List<Address> addressList) {
		this.addressList = addressList;
	}
}
