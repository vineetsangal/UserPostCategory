package com.example.demo.Dto;

public class CategoryDto {
	private Integer CategoryId;
	private String CategoryTitle;
	private String CategoryDescription;
	

	
	public CategoryDto(Integer categoryId, String categoryTitle, String categoryDescription) {
		super();
		CategoryId = categoryId;
		CategoryTitle = categoryTitle;
		CategoryDescription = categoryDescription;
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
}
