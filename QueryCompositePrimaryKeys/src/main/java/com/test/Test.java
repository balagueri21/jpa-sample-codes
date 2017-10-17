package com.test;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.test.dao.UserDAO;
import com.test.model.User;
import com.test.model.UserPK;

public class Test {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-example");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		User user1 = new User();
		User user2 = new User();
		User user3 = new User();
		User user4 = new User();
		User user5 = new User();

		UserPK userPK1 = new UserPK(1L, "it");
		user1.setUserPK(userPK1);

		UserPK userPK2 = new UserPK(2L, "it");
		user2.setUserPK(userPK2);

		UserPK userPK3 = new UserPK(3L, "hr");
		user3.setUserPK(userPK3);

		UserPK userPK4 = new UserPK(4L, "eng");
		user4.setUserPK(userPK4);

		UserPK userPK5 = new UserPK(5L, "eng");
		user5.setUserPK(userPK5);

		em.persist(user1);
		em.persist(user2);
		em.persist(user3);
		em.persist(user4);
		em.persist(user5);

		em.getTransaction().commit();
		
		UserDAO userDAO = new UserDAO();
		userDAO.setEntityManager(em);
		
		// QUERY 1: query users by list of UserPKs
		List<UserPK> userPKs = new ArrayList<UserPK>();
		userPKs.add(new UserPK(1L, "it"));
		userPKs.add(new UserPK(4L, "eng"));
		List<User> userListQuery1 = userDAO.getUsersByIdCombo(userPKs);
		for (User user: userListQuery1) {
			System.out.println(user);
		}
		
		// QUERY 2: query users by list of ids
		List<Long> ids = new ArrayList<Long>();
		ids.add(2L);
		ids.add(5L);
		List<User> userListQuery2 = userDAO.getUsersById(ids);
		for (User user: userListQuery2) {
			System.out.println(user);
		}
		
		// QUERY 3: query users by list of groups
		List<String> groups = new ArrayList<String>();
		groups.add("it");
		groups.add("eng");
		List<User> userListQuery3 = userDAO.getUsersByGroup(groups);
		for (User user: userListQuery3) {
			System.out.println(user);
		}
		
		// QUERY 4: single user by id and by group
		User user = userDAO.getSingleUserByIdAndGroup(3L, "hr");
		System.out.println(user);
	}
}
