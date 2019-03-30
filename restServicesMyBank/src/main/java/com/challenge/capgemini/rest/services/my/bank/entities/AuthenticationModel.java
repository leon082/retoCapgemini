package com.challenge.capgemini.rest.services.my.bank.entities;

public class AuthenticationModel {

	private String username;
	private String password;
	
	public AuthenticationModel() {
		
	}
	
	public AuthenticationModel(String username, String password) {
		this.username = username;
		this.password = password;
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
	
	@Override
	public String toString() {
		return "AuthenticationModel [username=" + username + ", password=" + password + "]";
	}
	
}
