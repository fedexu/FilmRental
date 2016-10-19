package com.filmrental.dao;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import com.filmrental.model.Rents;

public class RentsDaoImpl implements RentsDao{
	
	private SessionFactory sessionFactory;
	
	public RentsDaoImpl() { 
    }
	
	public RentsDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
	
	protected Session getCurrentSession(){
	      return sessionFactory.getCurrentSession();
	}
	
	/* Provides a list of Rents with all the rents still active at the current time */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Rents> getAllRents() {
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(Rents.class);
		cr.add(Restrictions.isNull("returned"));
		try {
			return cr.list();
		} catch (HibernateException he) {
			System.out.println("Error in getting rents due to: " + he);
			he.printStackTrace();
			return null;
		}
	}
	
	/* Provides a list of Rents with all the rents of a particular user still 
	 * active at the current time  */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Rents> getRentsByUser(int id){
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(Rents.class);
		cr.add(Restrictions.eq("userId", id));
		cr.add(Restrictions.isNull("returned"));
		try {
			return cr.list();
		} catch (HibernateException he) {
			System.out.println("Error in getting rents due to: " + he);
			he.printStackTrace();
			return null;
		}
	}
	
	/* Provides the number of film that a user has rented*/
	@Override
	@Transactional
	public int getFilmCount(int id){
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(Rents.class);
		cr.add(Restrictions.eq("id", id));
		cr.add(Restrictions.isNull("returned"));
		cr.setProjection(Projections.rowCount());
		try{
			return (int) cr.uniqueResult();
		}
		catch(HibernateException he){
			System.out.println("Error in getting count due to: " + he);
			he.printStackTrace();
			return -1;
		}
	}
	
	/* Adds a new row with the current date and time as rental time  */
	@Override
	@Transactional
	public boolean rentFilm(int filmId, int userId ){
		Rents rent = new Rents();
		rent.setFilmId(filmId);
		rent.setUserId(userId);
		Date date = new Date();
		LocalDateTime ldt = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
		Date d = Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant());
		rent.setRented(d);
		try{
			sessionFactory.getCurrentSession().save(rent);
			return true;
		}
		catch(HibernateException he){
			System.out.println("Couldnt save rent due to: " + he);
			he.printStackTrace();
			return false;
		}
	}
	
	/* Adds a new row with the current date and time as return time  */
	@Override
	@Transactional
	public boolean returnFilm(int rentId) {
		String upq ="update Rents r set r.returned = :returned where r.id = :rentId"; 
		Date date = new Date();
		LocalDateTime ldt = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
		Date d = Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant());
		Query query = sessionFactory.getCurrentSession().createQuery(upq);
		query.setParameter("returned", d);
		query.setParameter("rentId", rentId);
		try{
			query.executeUpdate();
			return true;
		}
		catch(HibernateException he){
			System.out.println("Couldnt save return due to: " + he);
			he.printStackTrace();
			return false;
		}
	}

}
