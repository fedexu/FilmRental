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

import com.filmrental.model.User;

public class DBUsers {

	public DBUsers() {

	}

	public List<User> selectAllUsers() throws NamingException, SQLException {

		Context initContext;
		Context envContext;
		DataSource ds;
		Connection con = null;
		PreparedStatement prst = null;
		
		initContext = new InitialContext();
		envContext = (Context) initContext.lookup("java:/comp/env");
		ds = (DataSource) envContext.lookup("jdbc/orclhr");
		con = ds.getConnection();
		
		String sql = "SELECT * FROM USERS";
		prst = con.prepareStatement(sql);
		ResultSet rs = prst.executeQuery();
		List<User> list = new ArrayList<User>();
		
		while (rs.next()) {
			User user = new User();
			user.setUser_Id(rs.getInt("USER_ID"));
			user.setUsername(rs.getString("USERNAME"));
			user.setU_Pass(rs.getString("U_PASS"));
			user.setFirst_Name(rs.getString("FIRST_NAME"));
			user.setLast_Name(rs.getString("LAST_NAME"));
			list.add(user);
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
		return list;
	}
	

	public User selectUserDetails(String Username) throws NamingException, SQLException {
		
		Context initContext;
		Context envContext;
		DataSource ds;
		Connection con = null;
		PreparedStatement prst = null;
		
		initContext = new InitialContext();
		envContext = (Context) initContext.lookup("java:/comp/env");
		ds = (DataSource) envContext.lookup("jdbc/orclhr");
		con = ds.getConnection();
		
		String sql = "SELECT * FROM USERS WHERE USERNAME=?";
		prst = con.prepareStatement(sql);
		prst.setString(1, Username);
		// attenzione : quando usi ? parameter "java.sql.SQLException:
		// ORA-03115: tipo di dati o rappresentazione non supportati in rete "
		// non devi riassegnare sql a executeQuery!!!!!!!!! ridai la sql senza i
		// ?
		ResultSet rs = prst.executeQuery();
		
		User user2 = new User();
		while (rs.next()) {
			User user = new User();
			user.setUser_Id(rs.getInt("USER_ID"));
			user.setUsername(rs.getString("USERNAME"));
			user.setU_Pass(rs.getString("U_PASS"));
			user.setFirst_Name(rs.getString("FIRST_NAME"));
			user.setLast_Name(rs.getString("LAST_NAME"));
			user2=user;
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
		return user2;
	}
}
