package com.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.test.model.Address;
import com.test.model.Order;
import com.test.model.Product;
import com.test.model.ProductOrder;

public class Test {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-example");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		Order order = new Order();
		order.setQuantity(10);
		em.persist(order);
		
		Product product = new Product();
		product.setName("Coffee");
		em.persist(product);
		
		Address address = new Address();
		address.setState("CA");
		em.persist(address);
		
		ProductOrder productOrder = new ProductOrder();
		productOrder.setOrder(order);
		productOrder.setProduct(product);
		
		productOrder.getAddressList().add(address);
		address.getProductOrderList().add(productOrder);
		
		em.persist(productOrder);
		
		em.getTransaction().commit();
	}
}
