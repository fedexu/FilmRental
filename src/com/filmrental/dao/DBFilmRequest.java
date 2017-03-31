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

import com.filmrental.model.FilmRequest;

public class DBFilmRequest {

	public DBFilmRequest() {

	}

	public void addFilmRequest(FilmRequest reqfilm) {

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

			String sql = "INSERT INTO FILMREQUEST (USER_ID,TITLE,REGIST,EXIT_YEAR) VALUES(?,?,?,?)";
			st = con.prepareStatement(sql);
			st.setInt(1, reqfilm.getUser_Id());
			st.setString(2, reqfilm.getTitle());
			st.setString(3, reqfilm.getRegist());
			st.setInt(4, reqfilm.getExit_Year());
			st.executeUpdate();
			con.commit();

			System.out.println("l'utente ha suggerito un film");
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

	public List<FilmRequest> selectAllRequest() {

		Context initContext;
		Context envContext;
		DataSource ds;
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		List<FilmRequest> listr = new ArrayList<FilmRequest>();

		try {
			initContext = new InitialContext();
			envContext = (Context) initContext.lookup("java:/comp/env");
			ds = (DataSource) envContext.lookup("jdbc/orclhr");
			con = ds.getConnection();

			String sql = "SELECT * FROM FILMREQUEST";
			st = con.prepareStatement(sql);
			rs = st.executeQuery();
			while (rs.next()) {
				FilmRequest filmr = new FilmRequest();
				filmr.setUser_Id(rs.getInt("USER_ID"));
				filmr.setTitle(rs.getString("TITLE"));
				filmr.setRegist(rs.getString("REGIST"));
				filmr.setExit_Year(rs.getInt("EXIT_YEAR"));
				filmr.setRequest_Id(rs.getInt("REQUEST_ID"));
				listr.add(filmr);
			}
			rs.close();
			st.close();
			con.close();
			return listr;

		} catch (NamingException | SQLException e) {
			e.printStackTrace();
			return listr;

		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
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
