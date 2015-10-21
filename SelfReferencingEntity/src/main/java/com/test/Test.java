package com.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.test.model.Employee;

public class Test {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-example");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		Employee manager = new Employee();
		manager.setName("John");
		
		Employee emp1 = new Employee();
		emp1.setName("James");
		
		Employee emp2 = new Employee();
		emp2.setName("Anna");
		
		// define both sides of the relationship
		emp1.setManager(manager);
		emp2.setManager(manager);
		manager.getSubordinates().add(emp1);
		manager.getSubordinates().add(emp2);
		
		em.persist(manager);
		em.persist(emp1);
		em.persist(emp2);
		
		em.getTransaction().commit();
	}
}
