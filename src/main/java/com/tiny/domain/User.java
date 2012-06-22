package com.tiny.domain;

import lombok.Data;

@Data
public class User {
	String name;
	String company;
	String password;
	
	public User() {
	}
	
	public User(String name, String company, String password) {
		this.name = name;
		this.company = company;
		this.password = password;
	}
}