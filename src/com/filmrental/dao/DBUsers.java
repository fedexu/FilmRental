package com.filmrental.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import com.filmrental.model.User;
import com.filmrental.utils.HibernateUtil;

public class DBUsers {

	public DBUsers() {

	}

	public List<User> selectUserByCredential(String username, String password) {
		Session session = null;
		List<User> list = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			NativeQuery<User> query = session
					.createNativeQuery("SELECT * FROM USERS WHERE USERNAME=:USR AND U_PASS=:PSW");
			query.addEntity(User.class);
			query.setParameter("USR", username);
			query.setParameter("PSW", password);
			list = query.list();

		} catch (Exception e) {
			e.printStackTrace();
			if (session != null) {
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return list;
	}

	public User selectUserDetails(String username) {
		Session session = null;
		User user = null;
		List<User> list = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			NativeQuery<User> query = session.createNativeQuery("SELECT * FROM USERS WHERE USERNAME=:USR ");
			query.addEntity(User.class);
			query.setParameter("USR", username);
			user = query.uniqueResult();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return user;

	}

}
