package com.filmrental.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

public class DBFilms {

	public DBFilms() {

	}

	public List<Film> selectAllFilm() {

		Session session = null;
		List<Film> list = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			NativeQuery<Film> query = session.createNativeQuery("SELECT * FROM FILMS");
			query.addEntity(Film.class);
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

	public Film selectFilmDetails(String title){

		Session session = null;
		List<Film> list = null;
		Film film = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			NativeQuery<Film> query = session.createNativeQuery("SELECT * FROM FILMS WHERE TITLE=:TITLEIN");
			query.addEntity(Film.class);
			query.setParameter("TITLEIN", title);
			list = query.list();
			for (Film f : list) {
				film = f;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return film;

	}

	public void addCopies(String title, int number) {

		Session session = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();

			NativeQuery<Film> query = session.createNativeQuery("UPDATE FILMS SET QUANTITY=QUANTITY+? WHERE TITLE=?");
			query.addEntity(Film.class);
			query.setParameter(1, number);
			query.setParameter(2, title);
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

	public void removeCopies(String title, int number) {

		Session session = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();

			NativeQuery<Film> query = session.createNativeQuery("UPDATE FILMS SET QUANTITY=QUANTITY-? WHERE TITLE=?");
			query.addEntity(Film.class);
			query.setParameter(1, number);
			query.setParameter(2, title);
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

	public BigDecimal[] getNumberOfFilmRentedCopies(List<Film> list) {

		Session session = null;
		BigDecimal[] number = new BigDecimal[list.size()];
		String sql[] = new String[list.size()];
		NativeQuery<BigDecimal> query = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			for (int i = 0; i < list.size(); i++) {
				query = session.createNativeQuery(
						"SELECT COUNT(*) FROM FILMRENTED WHERE RETURN_DATE IS NULL AND FILM_ID=:FILMID");
				query.setParameter("FILMID", list.get(i).getFilmId());
				number[i] = query.uniqueResult();
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return number;

	}

	public BigDecimal getNumberOfThisFilmRentedCopies(String filmId) {

		Session session = null;
		BigDecimal ris = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();

			NativeQuery<BigDecimal> query = session
					.createNativeQuery("SELECT COUNT(*) FROM FILMRENTED WHERE RETURN_DATE IS NULL AND FILM_ID=:FILMID");
			query.setParameter("FILMID", filmId);
			ris = query.uniqueResult();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return ris;
	}

	public void addFilm(Film film) {

		Session session = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();

			NativeQuery<Film> query = session
					.createNativeQuery("INSERT INTO FILMS (TITLE,REGIST,EXIT_YEAR,QUANTITY) VALUES(?,?,?,?)");
			query.addEntity(Film.class);
			query.setParameter(1, film.getTitle());
			query.setParameter(2, film.getRegist());
			query.setParameter(3, film.getExitYear());
			query.setParameter(4, film.getQuantity());
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

	public void removeFilm(String filmId) {

		Session session = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();

			NativeQuery<Film> query = session.createNativeQuery("DELETE FROM FILMS WHERE FILM_ID=:FILMID");
			query.addEntity(Film.class);
			query.setParameter("FILMID", filmId);
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
