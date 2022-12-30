package com.medicalservice.user.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Login")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String password;
	private String role;
	private String userName;
	
	public User() {
		super();
	}



	public User(Long id, String password, String role, String userName) {
		super();
		this.id = id;
		this.password = password;
		this.role = role;
		this.userName = userName;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "user [id=" + id + ", password=" + password + ", role=" + role + ", userName=" + userName + "]";
	}

}
