package com.zabir.springboot.cms.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Category {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String title;
	private Integer parent;
	private String position;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
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

}
