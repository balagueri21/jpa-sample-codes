package com.test.model;

import java.io.Serializable;

public class ProductOrderId implements Serializable {

	private static final long serialVersionUID = 2689580689557287696L;

	private Long order;
	private Long product;

	public Long getOrder() {
		return order;
	}

	public void setOrder(Long order) {
		this.order = order;
	}

	public Long getProduct() {
		return product;
	}

	public void setProduct(Long product) {
		this.product = product;
	}
}
