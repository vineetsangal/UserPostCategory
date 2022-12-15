package com.example.demo.entites;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;



@Entity
public class Category {
	@Id
	@GeneratedValue
	private Integer CategoryId;
	private String CategoryTitle;
	private String CategoryDescription;
	@OneToMany(mappedBy = "category" , cascade = CascadeType.ALL)
	private List<Post>post = new ArrayList<>();
	public Category(Integer categoryId, String categoryTitle, String categoryDescription, List<Post> post) {
		super();
		CategoryId = categoryId;
		CategoryTitle = categoryTitle;
		CategoryDescription = categoryDescription;
		this.post = post;
	}
	public Integer getCategoryId() {
		return CategoryId;
	}
	public void setCategoryId(Integer categoryId) {
		CategoryId = categoryId;
	}
	public String getCategoryTitle() {
		return CategoryTitle;
	}
	public void setCategoryTitle(String categoryTitle) {
		CategoryTitle = categoryTitle;
	}
	public String getCategoryDescription() {
		return CategoryDescription;
	}
	public void setCategoryDescription(String categoryDescription) {
		CategoryDescription = categoryDescription;
	}
	public List<Post> getPost() {
		return post;
	}
	public void setPost(List<Post> post) {
		this.post = post;
	}
	
}