package com.filmrental.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import com.filmrental.model.Film;
import com.filmrental.model.FilmRent;
import com.filmrental.model.User;
import com.filmrental.utils.HibernateUtil;

public class DBFilmRent {

	public DBFilmRent() {
	}

	public List<FilmRent> selectAllFilmsRent() {

		Session session = null;
		List<FilmRent> list = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			NativeQuery<FilmRent> query = session.createNativeQuery("SELECT RENT_ID FROM FILMRENTED");
			query.addEntity(FilmRent.class);
			list = query.list();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return list;
	}

	public List<FilmRent> selectFilmsRentByUserId(User user){

		Session session = null;
		List<FilmRent> list = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			NativeQuery<FilmRent> query = session
					.createNativeQuery("SELECT FR.*,F.TITLE FROM FILMRENTED FR,FILMS F WHERE FR.FILM_ID = F.FILM_ID AND USER_ID=:USERID AND RETURN_DATE IS NULL");
			query.addEntity(FilmRent.class);
			query.setParameter("USERID", user.getUserId());
			list = query.list();
			

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return list;

	}

	public void addFilmRent(Film film, User user) {

		Session session = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			NativeQuery<FilmRent> query = session.createNativeQuery(
					"INSERT INTO FILMRENTED (USER_ID,FILM_ID,ORDER_DATE) VALUES(?,?,CURRENT_TIMESTAMP)");
			query.addEntity(FilmRent.class);
			query.setParameter(1, user.getUserId());
			query.setParameter(2, film.getFilmId());
			query.executeUpdate();
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			if (session != null) {
				session.getTransaction().rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}

	}

	public void returnFilmRent(int rentId) {

		Session session = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			NativeQuery<FilmRent> query = session
					.createNativeQuery("UPDATE FILMRENTED SET RETURN_DATE=CURRENT_TIMESTAMP WHERE RENT_ID=:RENTID");
			query.addEntity(FilmRent.class);
			query.setParameter("RENTID", rentId);
			query.executeUpdate();
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			if (session != null) {
				session.getTransaction().rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}

	}

}
