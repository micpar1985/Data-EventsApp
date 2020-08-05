package com.event_app.data_services.model;

import java.io.Serializable;

public class Customer implements Serializable{

	private static final long id = 1L;
	private String name;
	private String password;
	private String email;
	
	public Customer(String name, String password, String email) {
		this.name = name;
		this.password = password;
		this.email = email;
	}
	
	public long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "Customer " + name;
	}
}
