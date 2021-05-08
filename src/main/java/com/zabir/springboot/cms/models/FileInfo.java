//package com.zabir.springboot.cms.models;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//
//@Entity
//public class FileInfo {
//	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	private Integer id;
//	private String fileName;
//	private String fileType;
//	private Integer postId;
//	private Integer type;
//	
//	public FileInfo (
//		String fileName,
//		String fileType,
//		Integer postId,
//		Integer type
//		) {
//		
//		this.fileName = fileName;
//	    this.fileType = fileType;
//	    this.postId = postId;
//	    this.type = type;
//		
//	}
//	
//	public Integer getType() {
//		return type;
//	}
//	
//	public void setType(Integer type) {
//		this.type = type;
//	}
//	
//	public Integer getPostId() {
//		return postId;
//	}
//	
//	public void setPostId(Integer postId) {
//		this.postId = postId;
//	}
//	
//	public String getFileType() {
//		return fileType;
//	}
//	
//	public void setFileType(String fileType) {
//		this.fileType = fileType;
//	}
//	
//	public String getFileName() {
//		return fileName;
//	}
//	
//	public void setFileName(String fileName) {
//		this.fileName = fileName;
//	}
//}
