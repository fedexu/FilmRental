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

import com.filmrental.model.Film;
import com.filmrental.model.FilmRent;
import com.filmrental.model.User;

public class DBFilmRent {

	public DBFilmRent() {
	}

	public List<FilmRent> selectAllFilmsRent() throws NamingException, SQLException {

		Context initContext = new InitialContext();
		Context envContext = (Context) initContext.lookup("java:/comp/env");
		DataSource ds = (DataSource) envContext.lookup("jdbc/orclhr");
		Connection con = ds.getConnection();

		String sql = "SELECT * FROM FILMRENTED";
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		List<FilmRent> list = new ArrayList<FilmRent>();
		while (rs.next()) {
			FilmRent filmr = new FilmRent();
			filmr.setRent_Id(rs.getInt("RENT_ID"));
			filmr.setUser_Id(rs.getInt("USER_ID"));
			filmr.setUsername(rs.getString("USERNAME"));
			filmr.setFilm_Id(rs.getInt("FILM_ID"));
			filmr.setTitle(rs.getString("TITLE"));
			filmr.setOrder_Date(rs.getDate("ORDER_DATE"));
			list.add(filmr);
		}
		if (rs != null) {
			rs.close();
		}
		if (st != null) {
			st.close();
		}
		if (con != null) {
			con.close();
		}
		return list;
	}

	public List<FilmRent> selectFilmsRentByUserId(User user) throws NamingException, SQLException {
		
		Context initContext = new InitialContext();
		Context envContext = (Context) initContext.lookup("java:/comp/env");
		DataSource ds = (DataSource) envContext.lookup("jdbc/orclhr");
		Connection con = ds.getConnection();

		String sql = "SELECT * FROM FILMRENTED WHERE USER_ID=? AND RETURN_DATE IS NULL";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, user.getUser_Id());
		ResultSet rs = st.executeQuery();
		List<FilmRent> list = new ArrayList<FilmRent>();
		while (rs.next()) {
			FilmRent filmr = new FilmRent();
			filmr.setRent_Id(rs.getInt("RENT_ID"));
			filmr.setUser_Id(rs.getInt("USER_ID"));
			filmr.setUsername(rs.getString("USERNAME"));
			filmr.setFilm_Id(rs.getInt("FILM_ID"));
			filmr.setTitle(rs.getString("TITLE"));
			filmr.setOrder_Date(rs.getDate("ORDER_DATE"));
			list.add(filmr);
		}
		if (rs != null) {
			rs.close();
		}
		if (st != null) {
			st.close();
		}
		if (con != null) {
			con.close();
		}
		return list;
	}

	public void addFilmRent(Film film, User user) {
		
		Context initContext;
		Context envContext;
		DataSource ds;
		Connection con = null;
		PreparedStatement st = null;

		try {
			initContext = new InitialContext();
			envContext = (Context) initContext.lookup("java:/comp/env");
			ds = (DataSource) envContext.lookup("jdbc/orclhr");
			con = ds.getConnection();

			String sql = "INSERT INTO FILMRENTED (USER_ID,USERNAME,FILM_ID,TITLE,ORDER_DATE) VALUES(?,?,?,?,CURRENT_TIMESTAMP)";
			st = con.prepareStatement(sql);
			st.setInt(1, user.getUser_Id());
			st.setString(2, user.getUsername());
			st.setInt(3, film.getFilm_Id());
			st.setString(4, film.getTitle());
			st.executeUpdate();
			con.commit();

			System.out.println("l'utente ha restituito un film rent");
			st.close();
			con.close();

		} catch (NamingException | SQLException e) {
			e.printStackTrace();
			try {
				con.rollback();

			} catch (SQLException e1) {

				e1.printStackTrace();
			}
		} finally {
			try {
				if (st != null) {
					st.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
	}

	public void returnFilmRent(int Rent_Id) {
		
		Context initContext;
		Context envContext;
		DataSource ds;
		Connection con = null;
		PreparedStatement st = null;

		try {
			initContext = new InitialContext();
			envContext = (Context) initContext.lookup("java:/comp/env");
			ds = (DataSource) envContext.lookup("jdbc/orclhr");
			con = ds.getConnection();

			String sql = "UPDATE FILMRENTED SET RETURN_DATE=CURRENT_TIMESTAMP WHERE RENT_ID=?";
			st = con.prepareStatement(sql);
			st.setInt(1, Rent_Id);
			st.executeUpdate();
			con.commit();

			System.out.println("l'utente ha restituito un film rent");
			st.close();
			con.close();

		} catch (NamingException | SQLException e) {
			e.printStackTrace();
			try {
				con.rollback();

			} catch (SQLException e1) {

				e1.printStackTrace();
			}
		} finally {
			try {
				if (st != null) {
					st.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}

	}

}
