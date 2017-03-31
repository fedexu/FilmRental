package com.filmrental.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import com.filmrental.model.FilmRent;
import com.filmrental.model.FilmRequest;
import com.filmrental.utils.HibernateUtil;

public class DBFilmRequest {

	public DBFilmRequest() {

	}

	public void addFilmRequest(FilmRequest reqfilm) {

		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			NativeQuery<FilmRequest> query = session
					.createNativeQuery("INSERT INTO FILMREQUEST (USER_ID,TITLE,REGIST,EXIT_YEAR) VALUES(?,?,?,?)");
			query.addEntity(FilmRequest.class);
			query.setParameter(1, reqfilm.getUserId());
			query.setParameter(2, reqfilm.getTitle());
			query.setParameter(3, reqfilm.getRegist());
			query.setParameter(4, reqfilm.getExitYear());
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

	public List<FilmRequest> selectAllRequest() {

		Session session = null;
		List<FilmRequest> list = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			
			NativeQuery<FilmRequest> query = session.createNativeQuery("SELECT * FROM FILMREQUEST");
			query.addEntity(FilmRequest.class);
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

}
