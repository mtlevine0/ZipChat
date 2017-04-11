package com.mtlevine0.zipchat.repository;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.CachedRowSet;

import com.mtlevine0.zipchat.model.User;

public class UserDAO extends DAO {

	public void addUser(User user) {
		String sql = "INSERT INTO user VALUES('"+user.getUsername()+"','"+user.getPassword()+"','"+user.getRole()+"','"+user.getUuid()+"')";
		executeUpdateQuery(sql);	
	}
	
	public List<User> getAllUsers() {
		ArrayList<User> userList = new ArrayList<User>();
		String sql = "SELECT * FROM user";
		try {
			CachedRowSet crs = executeStatementQuery(sql);
	        while (crs.next()) {
	        	
	        	User user = new User();
	        	user.setUsername(crs.getString("username"));
	        	user.setPassword(crs.getString("passwordHash"));
	        	user.setRole(crs.getString("role"));
	        	user.setUuid(crs.getString("uuid"));
	            
	            userList.add(user);
	        }   
        } catch (SQLException ex){
	        System.err.println(ex);
        }
		return userList;
	}
	
}
