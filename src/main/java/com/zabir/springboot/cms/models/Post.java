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
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String title;
	
	@Column(columnDefinition = "text")
	private String description;
	private Integer category;
	@Column(length = 20)
	private String status;
	@Column(length = 2)
	private Integer language;
	
	@Column(columnDefinition = "text")
	private String tags;
	private String primaryPicture;
	
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
	
	public String getStatus() {
	    return status;
	}
	
	public void setStatus(String status) {
	    this.status = status;
	}
	
	public String getTags() {
	    return tags;
	}
	
	public void setTags(String tags) {
	    this.tags = tags;
	}
	
	public Integer getLanguage() {
	    return language;
	}
	
	public void setLanguage(Integer language) {
	    this.language = language;
	}

	public String getPrimaryPicture() {
		return primaryPicture;
	}

	public void setPrimaryPicture(String primaryPicture) {
		this.primaryPicture = primaryPicture;
	}
	
	

}
