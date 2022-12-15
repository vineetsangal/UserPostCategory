package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entites.Category;
import com.example.demo.entites.Post;
import com.example.demo.entites.User;

public interface PostRepository extends JpaRepository<Post,Integer>{
	List<Post>getByUser(User user);
	List<Post>getByCategory(Category category);

}
