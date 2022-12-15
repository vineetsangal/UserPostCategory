package com.example.demo.Dto;

import java.util.Date;



public class PostDto {
	private Integer postid;
	private String title;
	private String ImageName;
	private Date addedDate;
	public PostDto(Integer postid, String title, String imageName, Date addedDate) {
		super();
		this.postid = postid;
		this.title = title;
		ImageName = imageName;
		this.addedDate = addedDate;
	}
	public Integer getPostid() {
		return postid;
	}
	public void setPostid(Integer postid) {
		this.postid = postid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getImageName() {
		return ImageName;
	}
	public void setImageName(String imageName) {
		ImageName = imageName;
	}
	public Date getAddedDate() {
		return addedDate;
	}
	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}
	
}
	
		