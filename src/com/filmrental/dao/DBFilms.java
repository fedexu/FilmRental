package com.filmrental.dao;

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

import com.filmrental.model.Film;
import com.filmrental.model.User;

public class DBFilms {

	public DBFilms() {

	}

	public List<Film> selectAllFilm() throws NamingException, SQLException {

		Context initContext;
		Context envContext;
		DataSource ds;
		Connection con = null;
		Statement st = null;

		initContext = new InitialContext();
		envContext = (Context) initContext.lookup("java:/comp/env");
		ds = (DataSource) envContext.lookup("jdbc/orclhr");
		con = ds.getConnection();

		st = con.createStatement();
		String sql = "SELECT * FROM FILMS";
		ResultSet rs = st.executeQuery(sql);

		List<Film> list = new ArrayList<Film>();
		while (rs.next()) {
			Film film = new Film();
			film.setFilm_Id(rs.getInt("FILM_ID"));
			film.setTitle(rs.getString("TITLE"));
			film.setRegist(rs.getString("REGIST"));
			film.setExit_Year(rs.getInt("EXIT_YEAR"));
			film.setQuantity(rs.getInt("QUANTITY"));
			list.add(film);
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

	public Film selectFilmDetails(String Title) throws NamingException, SQLException {

		Context initContext;
		Context envContext;
		DataSource ds;
		Connection con = null;
		PreparedStatement prst = null;

		initContext = new InitialContext();
		envContext = (Context) initContext.lookup("java:/comp/env");
		ds = (DataSource) envContext.lookup("jdbc/orclhr");
		con = ds.getConnection();

		String sql = "SELECT * FROM FILMS WHERE TITLE=?";
		prst = con.prepareStatement(sql);
		prst.setString(1, Title);
		ResultSet rs = prst.executeQuery();

		Film film2 = new Film();
		while (rs.next()) {
			Film film = new Film();
			film.setFilm_Id(rs.getInt("FILM_ID"));
			film.setTitle(rs.getString("TITLE"));
			film.setRegist(rs.getString("REGIST"));
			film.setExit_Year(rs.getInt("EXIT_YEAR"));
			film.setQuantity(rs.getInt("QUANTITY"));
			film2 = film;
		}

		if (rs != null) {
			rs.close();
		}
		if (prst != null) {
			prst.close();
		}
		if (con != null) {
			con.close();
		}
		return film2;
	}

	public void addCopies(String Title, int number) {

		Context initContext;
		Context envContext;
		DataSource ds;
		Connection con = null;
		PreparedStatement prst = null;

		try {
			initContext = new InitialContext();
			envContext = (Context) initContext.lookup("java:/comp/env");
			ds = (DataSource) envContext.lookup("jdbc/orclhr");
			con = ds.getConnection();

			String sql = "UPDATE FILMS SET QUANTITY=QUANTITY+? WHERE TITLE=?";
			prst = con.prepareStatement(sql);
			prst.setInt(1, number);
			prst.setString(2, Title);
			prst.executeUpdate();
			con.commit();

			System.out.println("l'admin ha aggiunto copie ai film rentable");
			prst.close();
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
				if (prst != null) {
					prst.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
	}

	public void removeCopies(String Title, int number) {

		Context initContext;
		Context envContext;
		DataSource ds;
		Connection con = null;
		PreparedStatement prst = null;

		try {
			initContext = new InitialContext();
			envContext = (Context) initContext.lookup("java:/comp/env");
			ds = (DataSource) envContext.lookup("jdbc/orclhr");
			con = ds.getConnection();

			String sql = "UPDATE FILMS SET QUANTITY=QUANTITY-? WHERE TITLE=?";
			prst = con.prepareStatement(sql);
			prst.setInt(1, number);
			prst.setString(2, Title);
			prst.executeUpdate();
			con.commit();

			System.out.println("l'admin ha rimosso copie ai film rentable");
			prst.close();
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
				if (prst != null) {
					prst.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
	}

	public Integer[] getNumberOfFilmRentedCopies(List<Film> list) {

		Context initContext;
		Context envContext;
		DataSource ds;
		Connection con = null;
		PreparedStatement prst = null;
		Integer[] number = new Integer[list.size()];

		try {
			initContext = new InitialContext();
			envContext = (Context) initContext.lookup("java:/comp/env");
			ds = (DataSource) envContext.lookup("jdbc/orclhr");
			con = ds.getConnection();

			String sql[] = new String[list.size()];
			for (int i = 0; i < list.size(); i++) {
				sql[i] = "SELECT COUNT(*) FROM FILMRENTED WHERE RETURN_DATE IS NULL AND FILM_ID=?";
				prst = con.prepareStatement(sql[i]);
				prst.setInt(1, list.get(i).getFilm_Id());
				ResultSet rs = prst.executeQuery();
				while (rs.next()) {
					number[i] = rs.getInt("COUNT(*)");
				}
			}

			prst.close();
			con.close();

			return number;

		} catch (NamingException | SQLException e) {
			e.printStackTrace();
			try {
				con.rollback();

			} catch (SQLException e1) {

				e1.printStackTrace();
			}
			return number;

		} finally {

			try {
				if (prst != null) {
					prst.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
	}

	public int getNumberOfThisFilmRentedCopies(String film_id) {

		Context initContext;
		Context envContext;
		DataSource ds;
		Connection con = null;
		PreparedStatement prst = null;
		ResultSet rs = null;
		int number = 0;

		try {
			initContext = new InitialContext();
			envContext = (Context) initContext.lookup("java:/comp/env");
			ds = (DataSource) envContext.lookup("jdbc/orclhr");
			con = ds.getConnection();

			String sql = "SELECT COUNT(*) FROM FILMRENTED WHERE RETURN_DATE IS NULL AND FILM_ID=" + film_id;
			prst = con.prepareStatement(sql);
			rs = prst.executeQuery();
			while (rs.next()) {
				number = rs.getInt("COUNT(*)");
			}
			rs.close();
			prst.close();
			con.close();

			return number;

		} catch (NamingException | SQLException e) {
			e.printStackTrace();
			return number;

		} finally {

			try {
				if (rs != null) {
					rs.close();
				}
				if (prst != null) {
					prst.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
	}

	public void addFilm(Film film) {

		Context initContext;
		Context envContext;
		DataSource ds;
		Connection con = null;
		PreparedStatement prst = null;

		try {
			initContext = new InitialContext();
			envContext = (Context) initContext.lookup("java:/comp/env");
			ds = (DataSource) envContext.lookup("jdbc/orclhr");
			con = ds.getConnection();

			String sql = "INSERT INTO FILMS (TITLE,REGIST,EXIT_YEAR,QUANTITY) VALUES(?,?,?,?)";
			prst = con.prepareStatement(sql);
			prst.setString(1, film.getTitle());
			prst.setString(2, film.getRegist());
			prst.setInt(3, film.getExit_Year());
			prst.setInt(4, film.getQuantity());
			prst.executeUpdate();
			con.commit();

			System.out.println("l'admin ha aggiunto un nuovo film rentable alla collection");
			prst.close();
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
				if (prst != null) {
					prst.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
	}

	public void removeFilm(String film_id) {

		Context initContext;
		Context envContext;
		DataSource ds;
		Connection con = null;
		PreparedStatement prst = null;

		try {
			initContext = new InitialContext();
			envContext = (Context) initContext.lookup("java:/comp/env");
			ds = (DataSource) envContext.lookup("jdbc/orclhr");
			con = ds.getConnection();

			String sql = "DELETE FROM FILMS WHERE FILM_ID=? ";
			prst = con.prepareStatement(sql);
			prst.setInt(1, Integer.parseInt(film_id));
			prst.executeUpdate();
			con.commit();

			System.out.println("l'admin ha rimosso un nuovo film rentable alla collection");
			prst.close();
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
				if (prst != null) {
					prst.close();
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
