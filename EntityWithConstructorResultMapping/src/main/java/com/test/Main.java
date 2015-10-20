package com.test;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.test.model.AnotherStudent;
import com.test.model.Student;

public class Main {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-example");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		AnotherStudent aStudent1 = new AnotherStudent();
		aStudent1.setName("Israel");
		aStudent1.setAddress("Pasig");
		aStudent1.setDateOfBirth(new Date());
		em.persist(aStudent1);
		
		AnotherStudent aStudent2 = new AnotherStudent();
		aStudent2.setName("Pearl");
		aStudent2.setAddress("Bulacan");
		aStudent2.setDateOfBirth(new Date());
		em.persist(aStudent2);
		
		String sql = "SELECT name, address, date_of_birth FROM another_student";
		Query q = em.createNativeQuery(sql, "StudentMapping");
		List results = q.getResultList();
		
		Iterator iter = results.iterator();
		while (iter.hasNext()) {
			Student student = (Student) iter.next();
			em.persist(student);
		}
		
		em.getTransaction().commit();
	}
}
