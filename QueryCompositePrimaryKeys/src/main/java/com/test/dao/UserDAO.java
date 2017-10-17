package com.test.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.test.model.User;
import com.test.model.UserPK;

public class UserDAO {

	private EntityManager entityManager;

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public List<User> getUsersByIdCombo(List<UserPK> ids) {
		TypedQuery<User> q = entityManager.createQuery("SELECT u FROM User AS u WHERE u.userPK IN :ids", User.class);
		q.setParameter("ids", ids);
		return q.getResultList();
	}
	
	public List<User> getUsersById(List<Long> ids) {
		TypedQuery<User> q = entityManager.createQuery("SELECT u FROM User AS u WHERE u.userPK.id IN :ids", User.class);
		q.setParameter("ids", ids);
		return q.getResultList();
	}
	
	public List<User> getUsersByGroup(List<String> groups) {
		TypedQuery<User> q = entityManager.createQuery("SELECT u FROM User AS u WHERE u.userPK.group IN :groups", User.class);
		q.setParameter("groups", groups);
		return q.getResultList();
	}
	
	public User getSingleUserByIdAndGroup(Long id, String group) {
		TypedQuery<User> q = entityManager.createQuery("SELECT u FROM User AS u WHERE u.userPK.id = :id AND u.userPK.group = :group", User.class);
		q.setParameter("id", id);
		q.setParameter("group", group);
		return q.getSingleResult();
	}
}
