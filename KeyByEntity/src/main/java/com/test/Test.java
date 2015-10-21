package com.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.test.model.Owner;
import com.test.model.Share;

public class Test {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-example");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		Owner owner1 = new Owner();
		Owner owner2 = new Owner();
		
		em.persist(owner1);
		em.persist(owner2);
		
		Share share = new Share();
		share.getOwnerSharesMap().put(owner1, 20);
		share.getOwnerSharesMap().put(owner2, 40);
		
		em.persist(share);
		
		em.getTransaction().commit();
	}
}
