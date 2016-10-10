package com.filmrental.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.filmrental.model.Users;

@Repository
public class UsersDaoImpl implements UsersDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	public UsersDaoImpl() { 
    }
	
	public UsersDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
	
	protected Session getCurrentSession(){
	      return sessionFactory.getCurrentSession();
	}
	
	/* Provides a list of all users */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Users> getAllUsers(){
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(Users.class);
		try{
			return cr.list();
		} catch (HibernateException he) {
			System.out.println("Error in getting users due to: " + he);
			he.printStackTrace();
			return null;
		}
	}
	
	/* Provides the user with the specified id */
	@Override
	@Transactional
	public Users getUserById(int id) {
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(Users.class);
		cr.add(Restrictions.eq("id", id));
		try {
			return (Users) cr.uniqueResult();
		} catch (HibernateException he) {
			System.out.println("Error in getting user due to: " + he);
			he.printStackTrace();
			return null;
		}
	}
	
	/* Provides the user with the specified name */
	@Override
	@Transactional
	public Users getUserByUsername(String username) {
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(Users.class);
		cr.add(Restrictions.ilike("username", username));
		try {
			Users r = (Users) cr.uniqueResult();
			return r;
		} catch (HibernateException he) {
			System.out.println("Error in getting user due to: " + he);
			he.printStackTrace();
			return null;
		}
	}
}
