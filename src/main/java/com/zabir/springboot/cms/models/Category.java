package com.zabir.springboot.cms.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Category {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String title;
	private String description;
	private Integer parent;
	private String position;
	@Column(length = 2)
	private Integer status;
	@Column(length = 2)
	private Integer language;
	
	
	public Integer getCategoryId() {
		return id;
	}
	
	public void setCategoryId(Integer id) {
	    this.id = id;
	}
	
	public String getTitle() {
	    return title;
	}
	
	public void setTitle(String title) {
	    this.title = title;
	}
	

	
	public Integer getParent() {
	    return parent;
	}
	
	public void setParent(Integer parent) {
	    this.parent = parent;
	}
	
	public String getPosition() {
	    return position;
	}
	
	public void setPosition(String position) {
	    this.position = position;
	}
	
	public Integer getStatus() {
	    return status;
	}
	
	public void setStatus(Integer status) {
	    this.status = status;
	}
	
	public Integer getLanguage() {
	    return language;
	}
	
	public void setLanguage(Integer language) {
	    this.language = language;
	}
	
	public String getDescription() {
	    return description;
	}
	
	public void setDescription(String description) {
	    this.description = description;
	}
}
