package com.mtlevine0.zipchat.repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import javax.sql.rowset.CachedRowSet;

import com.sun.rowset.CachedRowSetImpl;

public class DAO {
	
    private DataSource dataSource;
	
	protected ResultSet executeUpdateQuery(String query) {
		ResultSet rs = null;
		Connection conn = null;
		
		try {
			Context initContext = new InitialContext();
		    Context envContext = (Context)initContext.lookup("java:comp/env");
		    dataSource = (DataSource) envContext.lookup("jdbc/MySQLZipChat");
		} catch(NamingException ex) {
			throw new RuntimeException(ex);   
		}

		try {
			conn = dataSource.getConnection();
	        Statement statement = conn.createStatement();
	        statement.executeUpdate(query);
	    	conn.close();
	    } catch (SQLException ex) {
	        System.err.println(ex);
	    }
		return rs;
	}
	
	protected CachedRowSet executeStatementQuery(String query) {
		ResultSet rs = null;
		Connection conn = null;
		CachedRowSet crs = null;
		try {
			crs = new CachedRowSetImpl();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			Context initContext = new InitialContext();
		    Context envContext = (Context)initContext.lookup("java:comp/env");
		    dataSource = (DataSource) envContext.lookup("jdbc/MySQLZipChat");
		} catch(NamingException ex) {
			throw new RuntimeException(ex);   
		}

		try {
			conn = dataSource.getConnection();
	        Statement statement = conn.createStatement();
	        rs = statement.executeQuery(query);
	        crs.populate(rs);
	    	conn.close();
	    } catch (SQLException ex) {
	        System.err.println(ex);
	    }
		return crs;
	}

}
