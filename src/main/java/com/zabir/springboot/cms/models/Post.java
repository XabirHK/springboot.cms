package com.zabir.springboot.cms.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.websocket.Decoder.Text;

@Entity
public class Post {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String title;
	
	@Column(columnDefinition = "text")
	private String description;
	private Integer category;
	private String picture;
	
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
	
	public String getDescription() {
	    return description;
	}
	
	public void setDescription(String description) {
	    this.description = description;
	}
	
	public Integer getCategory() {
	    return category;
	}
	
	public void setCategory(Integer category) {
	    this.category = category;
	}
	
	public String getPicture() {
	    return picture;
	}
	
	public void setPicture(String picture) {
	    this.picture = picture;
	}
	
	

}
