package com.mtlevine0.zipchat.model;

import java.util.UUID;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User {
	
	private String username;
	private String password;
	private String role;
	private String uuid;
	
	public User(String username, String password, String role) {
		System.out.println("Constructor called!");
		this.username = username;
		this.password = password;
		this.role = role;
		this.uuid = UUID.randomUUID().toString();
	}
	
	public User() {
		System.out.println("Empty Constructor Called!");
	}
	
	public boolean createUser() {
		boolean status = false;
		if(this.usernameAvailable()) {
			this.uuid = UUID.randomUUID().toString();
			status = true;
			System.out.println("User created!");
		}
		return status;
	}
	
	public boolean usernameAvailable() {
		return true;
	}
	
	public boolean authenticateUser() {
		return this.password.equals("password");
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

}
