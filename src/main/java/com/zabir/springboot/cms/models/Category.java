package com.zabir.springboot.cms.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Category {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer category_id;
	private String title;
	private String description;
	private Integer parent;
	private String position;
	private String status;
	private Integer language;
	
	public Integer getCategoryId() {
		return category_id;
	}
	
	public void setCategoryId(Integer category_id) {
	    this.category_id = category_id;
	}
	
	public String getTitle() {
	    return title;
	}
	
	public void setTitle(String title) {
	    this.title = title;
	}
	
	public String getDescription() {
	    return description;
	}
	
	public void setDescription(String description) {
	    this.description = description;
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
	
	public String getStatus() {
	    return status;
	}
	
	public void setStatus(String status) {
	    this.status = status;
	}
	
	public Integer getLanguage() {
	    return language;
	}
	
	public void setLanguage(Integer language) {
	    this.language = language;
	}

}
