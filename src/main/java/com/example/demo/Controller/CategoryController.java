package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Dto.CategoryDto;
import com.example.demo.Service.CategoryService;

@RestController
public class CategoryController {
	@Autowired
	private CategoryService categoryService;
	
	@PostMapping("/")
	public ResponseEntity<CategoryDto>createCategory(@RequestBody CategoryDto categoryDto){
		CategoryDto cat = this.categoryService.createCategory(categoryDto);
		return new ResponseEntity<>( cat ,HttpStatus.OK);
	}
	@PutMapping("/{catid}")
	public ResponseEntity<CategoryDto>UpdateCategory(@RequestBody CategoryDto categoryDto , @PathVariable Integer catid){
	CategoryDto updatecat = 	this.categoryService.updateCategory(categoryDto, catid);
	return new ResponseEntity<>(updatecat, HttpStatus.OK);
	}
	@GetMapping("/{catid}")
	public ResponseEntity<CategoryDto>GetCategoryById(@PathVariable Integer catid){
	CategoryDto Getcategory = 	this.categoryService.getCategoryById(catid);
	return new ResponseEntity<>( Getcategory , HttpStatus.FOUND);
	}
	@GetMapping("/")
	public ResponseEntity<List<CategoryDto>>GetAllCategory(){
	List<CategoryDto>list = 	this.categoryService.getAllCategory();
	return ResponseEntity.ok(list);
	  // return ResponseEntity.ok(this.categoryService.getAllCategory());
	}
	@DeleteMapping("/{catid}")
	 public ResponseEntity<?>DeleteCategory(@PathVariable Integer catid){
		 this.categoryService.deleteCategory(catid);
		 return ResponseEntity.ok(null);
	 }

}
