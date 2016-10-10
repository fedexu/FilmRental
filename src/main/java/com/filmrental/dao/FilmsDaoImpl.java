package com.filmrental.dao;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.filmrental.model.Films;

@Repository
public class FilmsDaoImpl implements FilmsDao {

	@Autowired
	SessionFactory sessionFactory;

	public FilmsDaoImpl() {
	}
	
	public FilmsDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
	
	protected Session getCurrentSession(){
	      return sessionFactory.getCurrentSession();
	}

	/*
	 * Adds a new film to the database specifying if it comes from a user
	 * request a external request or the administrator [requested 1, 2, 0
	 * respectively]
	 */
	@Override
	@Transactional
	public boolean addFilm(String title, int copies, int requested, boolean approved) {
		Films film = new Films();
		film.setTitle(title);
		film.setCopies(copies);
		film.setRequested(requested);
		film.setApproved(approved);
		try {
			sessionFactory.getCurrentSession().save(film);
			return true;
		} catch (HibernateException he) {
			System.out.println("Couldn't add new filme due to: " + he);
			he.printStackTrace();
			return false;
		}
	}

	/* Provides the film with the specified id */
	@Override
	@Transactional
	public Films getFilmById(int id) {
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(Films.class);
		cr.add(Restrictions.eq("id", id));
		try {
			return (Films) cr.uniqueResult();
		} catch (HibernateException e) {
			System.out.println("Error in getting film due to: " + e);
			e.printStackTrace();
			return null;
		}
	}

	/* Provides a list of Films of all the films in the database */
	@Override
	@Transactional
	@SuppressWarnings("unchecked")
	public List<Films> getAllFilms() {
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(Films.class);
		try {
			return (List<Films>) cr.uniqueResult();
		} catch (HibernateException e) {
			System.out.println("Error in getting film list due to: " + e);
			e.printStackTrace();
			return null;
		}
	}

	/* Set a suggested film as approved to be rented */
	@Override
	@Transactional
	public boolean setApproved(int id) {
		String hql = "update Films f set f.approved = 1 where f.id = :id";
		Query q = sessionFactory.getCurrentSession().createQuery(hql);
		q.setParameter("id", id);
		try {
			int updatedEntities = q.executeUpdate();
			System.out.println("Updated : " + updatedEntities + "entities.");
			return true;
		} catch (Exception e) {
			System.out.println("Error in updating approval due to: " + e);
			e.printStackTrace();
			return false;
		}
	}

	/* Set the number of copies of the film that will be possible to rent */
	@Override
	@Transactional
	public boolean setCopies(int id, int copies) {
		String hql = "update Films f set f.copies = :copies where f.id = :id";
		Query q = sessionFactory.getCurrentSession().createQuery(hql);
		q.setParameter("copies", copies);
		q.setParameter("id", id);
		try {
			int updatedEntities = q.executeUpdate();
			System.out.println("Updated : " + updatedEntities + "entities.");
			return true;
		} catch (Exception e) {
			System.out.println("Error in updating approval due to: " + e);
			e.printStackTrace();
			return false;
		}
	}

	/* Get all the requested films not approved yet*/
//TODO String hql="select title, count(*) as num from Requests group by title order by num desc"
//vorrei metterli in ordine decrescente
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Films> getAllActiveRequests() {
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(Films.class);
		cr.add(Restrictions.eq("approved", false));
		try {
			return (List<Films>) cr.list();
		} catch (HibernateException e) {
			System.out.println("Error in getting film list due to: " + e);
			e.printStackTrace();
			return null;
		}
	}

	/* Get all the requested films approved*/
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Films> getAllRentableFilms() {
		String hql = "SELECT d.id, d.title, CASE WHEN d.copiesb IS NULL THEN d.copies ELSE (d.copies - d.copiesb) END AS e FROM "
				+ "(SELECT * FROM   "
				+ "(SELECT id AS idb, title AS titleb, b.copies AS CopiesB FROM   videorental.films AS a, "
				+ "(SELECT filmid, Count(*) AS Copies FROM videorental.rents WHERE returned IS NULL GROUP  BY filmid) AS b "
				+ "WHERE  a.id = b.filmid AND b.copies < a.copies) AS c "
				+ "RIGHT JOIN (SELECT * FROM Films WHERE approved = 1) as f ON f.id = c.idb) AS d; ";
		Query query = sessionFactory.getCurrentSession().createSQLQuery(hql);
		try {
			ArrayList<Films> resultcast = new ArrayList<Films>();
			List<Object[]> result =  (List<Object[]>) query.list();
			for(Object[] l : result) {
				Films f = new Films();
				f.setId((int) l[0]);
				f.setTitle((String)l[1]);
				f.setCopies( ((BigInteger) l[2]).intValue());
				resultcast.add(f);
			}
			
			return resultcast;
		} catch (HibernateException e) {
			System.out.println("Error in getting film list due to: " + e);
			e.printStackTrace();
			return null;
		}
	}
}
