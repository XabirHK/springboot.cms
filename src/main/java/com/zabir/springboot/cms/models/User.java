package com.zabir.springboot.cms.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


@Entity
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String username;
	private String email;
	private String password;
	
	@ManyToMany
	private Set<Role> roles = new HashSet<>();
	
	public User() {
	}

	public User(String username, String email, String password) {
		this.username = username;
		this.email = email;
		this.password = password;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
	    this.id = id;
	}
	
	public String getUsername() {
	    return username;
	}
	
	public void setUsername(String name) {
	    this.username = name;
	}
	
	public String getEmail() {
	    return email;
	}
	
	public void setEmail(String email) {
	    this.email = email;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Role> getRole() {
		return roles;
	}

	public void setRole(Set<Role> roles) {
		this.roles = roles;
	}

}
