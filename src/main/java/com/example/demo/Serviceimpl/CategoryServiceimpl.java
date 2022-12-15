package com.example.demo.Serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Dto.CategoryDto;
import com.example.demo.Repository.CategoryRepo;
import com.example.demo.Service.CategoryService;
import com.example.demo.entites.Category;
import com.example.demo.exception.ResourceNotFoundException;
@Service
public class CategoryServiceimpl implements CategoryService {
	@Autowired
	private CategoryRepo categoryRepo;
	@Autowired
	private ModelMapper modelMapper;
	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {
   Category cat = 	this .modelMapper.map(categoryDto, Category.class);
   Category updatedcat= this.categoryRepo.save(cat);
    return this.modelMapper.map(updatedcat, CategoryDto.class);
	}
	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {
	  
	Category cat = 	this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("CategoryId" , "Id" , "CategoryId"));
	cat.setCategoryTitle(categoryDto.getCategoryTitle());
	cat.setCategoryDescription(categoryDto.getCategoryDescription());
  Category update = this.categoryRepo.save(cat);
  return this.modelMapper.map(update, CategoryDto.class);
	}
	@Override
	public CategoryDto getCategoryById(Integer categoryId) {
		Category cat = 	this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("CategoryId" , "Id" , "CategoryId"));
	Category get =	this.categoryRepo.save(cat);
	return this.modelMapper.map(get, CategoryDto.class);
	}
	@Override
	public List<CategoryDto> getAllCategory() {
		List<Category>list = this.categoryRepo.findAll();
		return list.stream().map(cat->this.modelMapper.map(cat, CategoryDto.class)).collect(Collectors.toList());
	}
	@Override
	public void deleteCategory(Integer categoryId) {
		Category cat = 	this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("CategoryId" , "Id" , "CategoryId"));
		this.categoryRepo.deleteById(categoryId);
	}
	

}
